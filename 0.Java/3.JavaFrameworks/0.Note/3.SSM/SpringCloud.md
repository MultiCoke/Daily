# SpringCloud

## 1.简介

### 1.1 什么是微服务架构

+ 微服务是系统架构上的一种设计风格,它的主旨是将一个原 本独立的系统拆分成多个小型服务,这些小型服务都在各自 独立的进程中运行,服务之间一般通过 HTTP 的 RESTfuL API 进行通信协作

+ 被拆分成的每一个小型服务都围绕着系统中的某一项或些 耦合度较高的业务功能进行构建,并且每个服务都维护着白 身的数据存储、业务开发自动化测试案例以及独立部署机 制。
+ 由于有了轻量级的通信协作基础,所以这些微服务可以使用 不同的语言来编写。

### 1.2 SpringCloud

+ Spring Cloud 是一系列框架的有序集合。 
+ Spring Cloud 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来。 
+ 通过 Spring Boot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。 
+ 它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。
+ Spring Cloud项目官方网址：https://spring.io/projects/spring-cloud

### 1.3 SpringCloud 与 Dubbo对比

+ Spring Cloud 与 Dubbo 都是实现微服务有效的工具。 
+ Dubbo 只是实现了服务治理，而 Spring Cloud 子项目分别覆盖 了微服务架构下的众多部件。 
+ Dubbo 使用 RPC 通讯协议，Spring Cloud 使用 RESTful 完成 通信，Dubbo 效率略高于 Spring Cloud。

![image-20201206190213244](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201206190213244.png)

## 2.服务治理

### 2.1 Eureka

![image-20201206190337672](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201206190337672.png)

+ 搭建 Provider 和 Consumer 服务。

  + 依赖

    ```xml
     <!--spring boot web-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
            <!-- eureka-client -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
    ```

  + 配置文件

      ```yml
      server:
        port: 9000

      eureka:
        instance:
          hostname: localhost # 主机名
        client:
          service-url:
            defaultZone: http://localhost:8761/eureka # eureka服务端地址，将来客户端使用该地址和eureka进行通信

      spring:
        application:
          name: eureka-provider # 设置当前应用的名称。将来会在eureka中Application显示。将来需要使用该名称来获取路径
      ```

  + RestTemplateConfig

    ```java
    @Configuration
    public class RestTemplateConfig {
    
        @Bean
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }
    }
    ```

  + 启动类上加上`@EnableEurekaClient`

  + Provider 向外暴露Restful接口，并注册到Eureka中

  + Consumer使用

    ```java
    @Autowired
    private DiscoveryClient discoveryClient;
    
    List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER"); // 服务名
    ServiceInstance instance = instances.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    Goods goods = restTemplate.getForObject(url, Goods.class);
    ```

+ 搭建Server

  + 依赖

    ```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- eureka-server -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
    ```

  + 配置文件

    ```yml
    server:
      port: 8761
    
    eureka:
      instance:
        hostname: localhost # 主机名
      client:
        service-url:
          defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka # eureka服务端地址，将来客户端使用该地址和eureka进行通信
    
        register-with-eureka: false # 是否将自己的路径 注册到eureka上。eureka server 不需要的，eureka provider client 需要
        fetch-registry: false # 是否需要从eureka中抓取路径。eureka server 不需要的，eureka consumer client 需要
    ```

  + 启动类注解`@EnableEurekaServer`
  + 可直接访问后台监控面板

+ 配置

  + server : eureka 的服务端配置

    ```yml
    eureka:
        server:
            #是否开启自我保护机制，默认true,开启了自我保护当服务提供方心跳数据不对时在规定时间内不进行处理
            enable-self-preservation:
            #清理间隔（单位毫秒，默认是60*1000）
            eviction-interval-timer-in-ms:
    ```

  + instance : eureka 的实例配置

    ```yml
    eureka:
        instance:
            hostname: localhost # 主机名
            prefer-ip-address: # 是否将自己的ip注册到eureka中，默认false 注册 主机名
            ip-address: # 设置当前实例ip
            instance-id: # 修改instance-id显示
            lease-renewal-interval-in-seconds: 30 # 每一次eureka client 向 eureka server发送心跳的时间间隔
            lease-expiration-duration-in-seconds: 90 # 如果90秒内eureka server没有收到eureka client的心跳包，则剔除该服务
    ```

  + client : eureka 的客户端配置

    ```yml
    eureka:
        client:
        	service-url:
        		# eureka服务端地址，将来客户端使用该地址和eureka进行通信
        		defaultZone: http://localhost:8761/eureka
        	register-with-eureka: # 是否将自己的路径 注册到eureka上。
        	fetch-registry: # 是否需要从eureka中抓取数据。
    ```

  + dashboard : eureka 的web控制台配置

    ```yml
    eureka:
        dashboard:
            enabled: true # 是否启用eureka web控制台
            path: / # 设置eureka web控制台默认访问路径
    ```

+ 高可用，搭建Eureka集群，服务端节点相互注册

+ 客服端注册到多个服务端，用`,`隔开

  ```yml
  eureka:
    instance:
      hostname: eureka-server1 # 主机名
    client:
      service-url:
        defaultZone: http://eureka-server2:8762/eureka
      register-with-eureka: true # 是否将自己的路径 注册到eureka上。eureka server 不需要的，eureka provider client 需要
      fetch-registry: true # 是否需要从eureka中抓取路径。eureka server 不需要的，eureka consumer client 需要
  
  
  spring:
    application:
      name: eureka-server-ha // 相同的服务名
  ```

+ 类似的注册中心还有 Consul，Nacos = 注册中心 + 配置中心，阿里巴巴出品，启动类注解 `@EnableDiscoveryClient `

  + `@EnableDiscoveryClient`注解是基于`spring-cloud-commons`依赖，并且在classpath中实现； 
  + `@EnableEurekaClient`注解是基于`spring-cloud-netflix`依赖，只能为eureka作用；

### 2.2 Consul

### 2.3 Nacos

## 3. 负载均衡 
+ ribbon：负载均衡器，集成在Eureka中，多种负载均衡算法

+ 配置：

  + 使用

  ```java
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
  	return new RestTemplate();
  }
  ```

  ```java
  String url = "http://user-service/user/" + id; // url的ip替换为服务名
  ```

  + 配置负载均衡算法，默认为随机，可选

    ```yml
    # 在消费客户端进行配置
    ser-service:
        ribbon:
            NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
    策略Irule：
            RoundRobinRule
                轮询
            WeighedResponseTimeRule
                响应速度快的实例选择权重大
            RandomRule
                随机
            RetryRule
                先按照RoundRobinRule策略获取，失败后会重试(重试试还是找本次获取的实例，还是找另一个？？)
            BestAvailableRule
                过滤掉多次访问而处于短路器跳闸状态的服务，然后选择一个并发小的
            ZoneAvoidanceRule
                默认规则，符合判断server所在域的性能和server的可用性选择服务器
            根据响应时间加权
    ```

  + 自定义负载均衡算法

    ```java
    // 启动类注解，需要为特定的功能区客户端自定义功能区设置时使用
    @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CloudRondowRule.class)
    ```

    ```java
    @Configuration
    public class CloudRondowRule {
    
        @Bean
        public IRule iRule() {
            return new RandomRule();　　//随机的规则
        }
    }
    ```

##  4. 声明式访问

+ Feign：

  + Feign 是一个声明式的 REST 客户端，可以使用配置接口的方式，将服务地址与接口进行绑定，在消费端只需要调用接口方法即可调用服务
  + Feign集成了Ribbon，进行了封装

+ 配置

  + 依赖

      ```xml
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-openfeign</artifactId>
      </dependency>
      ```
  
+ 客户端接口类
  
    ```java
    @FeignClient("user-service") // 服务提供名
    public interface UserClient {
        @GetMapping("/user/{id}") // 服务接口
        User queryById(@PathVariable("id") Long id);
    }
    ```

  + 启动类注解  `@EnableFeignClients`  开启Feign功能

+ 请求超时，调用服务时的超时时间设置

  ```yml
  ribbon:
      ConnectTimeout: 1000 # 连接超时时长
      ReadTimeout: 2000 # 数据通信超时时长
      MaxAutoRetries: 0 # 当前服务器的重试次数
      MaxAutoRetriesNextServer: 0 # 重试多少次服务
      OkToRetryOnAllOperations: false # 是否对所有的请求方式都重试
  ```

+ 日志记录，只能记录debug级别的日志

  + 配置

    ```yml
    logging:
        level:
            com.itheima: debug	# 包名:
    ```

  + Bean

    ```java
    // 定义Feign日志级别Bean
    @Bean
    Logger.Level feignLoggerLevel() {
    	return Logger.Level.FULL;
    }
    ```

  + 接口配置注解参数 `@FeignClient(configuration = XxxConfig.class)`

## 5. 熔断器

+ Hystrix:
  + Hystix 是 Netflix 开源的一个延迟和容错库，用于隔离访问远程服务、第三方库，防止出现级联失败（雪崩）。 
  + 雪崩：一个服务失败，导致整条链路的服务都失败的情形。 
  + Hystix 主要功能 
    + 隔离  
      + 线程隔离，指定每个服务的线程数
      + 信号量隔离，当线程数达到一定时停止访问
    + 降级 
    + 熔断 
    + 限流

+ 降级：当服务发生异常或调用超时，返回默认数据

  ![image-20201207090457437](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207090457437.png)

  + 服务提供方降级

    + 降级原因：

      + 任务处理超时
      + 任务处理异常

    + 依赖

      ```xml
      <!-- hystrix -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
      </dependency>
      ```

    + 定义降级方法

      ```java
      // 方法上加上注解
      @HystrixCommand(fallbackMethod = "findOne_fallback",commandProperties = {
                  //设置Hystrix的超时时间，默认1s
                  @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
          
      /**
      * 定义降级方法：
      *  1. 方法的返回值需要和原方法一样
      *  2. 方法的参数需要和原方法一样
      */
      public Goods findOne_fallback(int id){
      	Goods goods = new Goods();
      	goods.setTitle("降级了~~~");
      	return goods;
      }
      ```

    + 启动类注解`@EnableCircuitBreake`

  + 服务消费方降级

    + 降级原因：

      + 调用超时

    + 依赖：feign已经继承hystrix

    + 实现feign接口，重写接口方法

      ```java
      /**
       * Feign 客户端的降级处理类
       * 1. 定义类 实现 Feign 客户端接口
       * 2. 使用@Component注解将该类的Bean加入SpringIOC容器
       */
      @Component
      public class GoodsFeignClientFallback implements GoodsFeignClient {
          @Override
          public Goods findGoodsById(int id) {
              Goods goods = new Goods();
              goods.setTitle("又被降级了~~~");
              return goods;
          }
      }
      ```

    + 原接口上注解配置属性`@FeignClient(value = "HYSTRIX-PROVIDER",fallback = GoodsFeignClientFallback.class)`

    + 配置文件

      ```yml
      # 开启feign对hystrix的支持
      feign:
        hystrix:
          enabled: true
      ```

+ 熔断：用于监控微服务调用情况，当失败的情况达到预定的阈值（5秒失败20次），会打开 断路器，拒绝所有请求，直到服务恢复正常为止。

![image-20201207095556587](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207095556587.png)

+ 配置

+ 注解

  ```java
  // 接口方法上加注解
  @HystrixCommand(fallbackMethod = "findOne_fallback",commandProperties = {
      //设置Hystrix的超时时间，默认1s
      @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
      //监控时间 默认5000 毫秒
      @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
      //失败次数。默认20次
      @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "20"),
      //失败率 默认50%
      @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
  
  })
  ```

+ 熔断监控 ：Hystrix 提供了 Hystrix-dashboard 功能，用于实 时监控微服务运行状态。 • 但是Hystrix-dashboard只能监控一个微服务。  Netflix 还提供了 Turbine ，进行聚合监控。

  + 监控模块 hystrix-monitor Turbine监控

    ```yml
    spring:
      application.name: hystrix-monitor
    server:
      port: 8769
    turbine:
      combine-host-port: true
      # 配置需要被监控的服务名称列表
      app-config: hystrix-provider,hystrix-consumer
      cluster-name-expression: "'default'"
      aggregator:
        cluster-config: default
      #instanceUrlSuffix: /actuator/hystrix.stream
    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/
    ```

    

    ```xml
    // 启动类注解
    @SpringBootApplication
    @EnableEurekaClient
    
    @EnableTurbine //开启Turbine 很聚合监控功能
    @EnableHystrixDashboard //开启Hystrix仪表盘监控功能
    
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-turbine</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```

  + 客户端

    ```java
    // 启动类注解
    @EnableDiscoveryClient // 激活DiscoveryClient
    @EnableEurekaClient
    @SpringBootApplication
    @EnableFeignClients //开启Feign的功能
    @EnableHystrixDashboard
    
    // 配置Bean
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
    ```

    

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>
    ```

  + 访问：http://localhost:8769/hystrix
  + 界面中输入监控的Url地址 http://localhost:8769/turbine.stream，监控时间间隔2000毫秒和title

## 6.网关

+ Gateway：网关就是系统的入口，封装了应用程序的内部结构，为客户端提 供统一服务，一些与业务本身功能无关的公共逻辑可以在这里实现， 诸如认证、鉴权、监控、缓存、负载均衡、流量管控、路由转发等

  ![image-20201207150240978](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207150240978.png)

+ 配置

  + 依赖

    ```xml
    <!--引入gateway 网关-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    
    <!-- eureka-client -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    ```

  + 配置文件

    ```yml
    server:
      port: 80
    
    spring:
      application:
        name: api-gateway-server
    
      cloud:
        # 网关配置
        gateway:
          # 路由配置：转发规则
          routes: #集合。
          # id: 唯一标识。默认是一个UUID
          # uri: 转发路径
          # predicates: 条件,用于请求网关路径的匹配规则
          # filters：配置局部过滤器的
    
          - id: gateway-provider
            # 静态路由
            # uri: http://localhost:8001/
            # 动态路由 lb://服务名
            uri: lb://GATEWAY-PROVIDER
            predicates:
            - Path=/goods/**
            # 局部过滤器，在过滤器工厂文件中可以找到配置
            filters:
            - AddRequestParameter=username,zhangsan
            
          - id: gateway-consumer
            # uri: http://localhost:9000
            uri: lb://GATEWAY-CONSUMER
            predicates:
            - Path=/order/**
          # 微服务名称配置
          discovery:
            locator:
              enabled: true # 设置为true 请求路径前可以添加微服务名称
              lower-case-service-id: true # 允许为小写
    
    eureka:
      client:
        service-url:
          defaultZone: http://localhost:8761/eureka
    ```

  + 启动类上加`EnableEurekaClient`找到注册中心

  + 过滤器

    ![image-20201207182409470](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207182409470.png)

    + 分pre 和 post 过滤器，在请求前后进行过滤

    + 分局部过滤器和全局过滤器，局部过滤器在网关配置中配置，全局过滤器实现接口`GlobalFilter, Ordered `

      ```java
      @Component
      public class MyFilter implements GlobalFilter, Ordered {
          @Override
          public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      
              System.out.println("自定义全局过滤器执行了~~~");
      
              return chain.filter(exchange);//放行
          }
      
          /**
           * 过滤器排序
           * @return 数值越小 越先执行
           */
          @Override
          public int getOrder() {
              return 0;
          }
      }
      ```

## 7.配置中心

+ Config：Spring Cloud Config 解决了在分布式场景下多环境配置文件的管理和维护。

  + 集中管理配置文件 

  + 不同环境不同配置，动态化的配置更新 

  + 配置信息改变时，不需要重启即可更新配置信息到服务

    ![image-20201207182702073](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207182702073.png)

+ 配置

  + 远程仓库，创建远程仓库用于存储配置文件，文件名由配置文件名加环境缩写组成，例如config-dev.yml

  + 服务端

    + 依赖，集成Eureka，用于注册服务，继承Bus，用于统一配置文件的刷新

      ```xml
      <!-- config-server -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-config-server</artifactId>
      </dependency>
      <!-- eureka -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
      </dependency>
      <!-- bus -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-bus-amqp</artifactId>
      </dependency>
      ```

    + 配置文件

      ```yml
      server:
        port: 9527
      
      spring:
        application:
          name: config-server
        # spring cloud config
        cloud:
          config:
            server:
              # git 的 远程仓库地址
              git:
                uri: https://gitee.com/mxxiv/springcloud_config.git
            label: master # 分支配置
      
      eureka:
        client:
          service-url:
            defaultZone: http://localhost:8761/eureka
      
      # 暴露bus的刷新端点 info  health bus-refresh
      management:
        endpoints:
          web:
            exposure:
              include: 'bus-refresh'
      ```

    + 启动类注解`@EnableConfigServer` 启用config server功能，`@EnableEurekaClient` 开启Eureka

  + 客户端

    + 依赖

      ```xml
      <!--config client -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-config</artifactId>
      </dependency>
      
      <!-- bus -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-bus-amqp</artifactId>
      </dependency>
      ```

    + 配置bootstrap.yml

      ```yml
      # 配置config-server地址
      # 配置获得配置文件的名称等信息
      spring:
        cloud:
          config:
            # 配置config-server地址
            # uri: http://localhost:9527
            # 配置获得配置文件的名称等信息
            name: config # 文件名
            profile: dev # profile指定，  config-dev.yml
            label: master # 分支
            # 从注册中心去寻找config-server地址
            discovery:
              enabled: true
              service-id: CONFIG-SERVER
        #配置rabbitmq信息
        rabbitmq:
          host: 192.168.110.75
          port: 5672
          username: guest
          password: guest
          virtual-host: /
      
      management:
        endpoints:
          web:
            exposure:
              include: '*'
      ```

    + 配置application.yml

      ```yml
      server:
        port: 8001
      
      eureka:
         client:
          service-url:
            defaultZone: http://localhost:8761/eureka
      spring:
        application:
          name: config-provider
      ```

    + Controller

      ```java
      @RefreshScope // 开启刷新功能，注解于Controller类上
      
      @Value("${itheima}")
      private String itheima; // 通过@Value获取配置文件的值，属性为key，获取的值为value
      ```

    + 刷新配置 POST请求 Config的actuator/bus-refresh

## 8.消息驱动

+ Stream: Spring Cloud Stream 构建的应用程序与消息中间件之间是通过绑定器 Binder 相关联的。绑定器对于应用程序而言起到了隔离作用， 它使得不同消息中间件 的实现细节对应用程序来说是透明的。 

  + binding 是我们通过配置把应用和spring cloud stream 的 binder 绑定在一起 

  + output：发送消息 Channel，内置 Source接口 

  + input：接收消息 Channel，内置 Sink接口

    ![image-20201207190346322](C:\Users\HY\Documents\Study\0.Java\3.JavaFrameworks\0.Note\3.SSM\SpringCloud.assets\image-20201207190346322.png)

+ 消息生产者

  + 依赖

    ```xml
    <!--spring boot web-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- stream -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
    </dependency>
    ```

  + 配置文件

    ```yml
    server:
      port: 8000
    
    spring:
      cloud:
        stream:
          # 定义绑定器，绑定到哪个消息中间件上　　
          binders:
            itheima_binder: # 自定义的绑定器名称
              type: rabbit # 绑定器类型
              environment: # 指定mq的环境
                spring:
                  rabbitmq:
                    host: 192.168.110.75
                    port: 5672
                    username: guest
                    password: guest
                    virtual-host: /
          bindings:
            output: # channel名称
              binder: itheima_binder #指定使用哪一个binder
              destination: itheima_exchange # 消息目的地，交换机
    ```

  + 配置消息发送Bean

    ```java
    @Component
    @EnableBinding(Source.class)
    public class MessageProducer {
    
        @Autowired
        private MessageChannel output;
    
        public void send(){
            String msessage = "hello stream~~~";
            //发送消息
            output.send(MessageBuilder.withPayload(msessage).build());
            System.out.println("消息发送成功~~~");
    
        }
    }
    ```

  + Controller使用

    ```java
    @Autowired
    private MessageProducer producer;
    
    @RequestMapping("/send")
    	public String sendMsg(){
    	producer.send();
    	return "success";
    }
    ```

+ 消息消费者

  + 依赖

    ```xml
    <!--spring boot web-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- stream -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
    </dependency>
    ```

  + 配置文件

    ```yml
    server:
      port: 9000
    
    spring:
      cloud:
        stream:
          # 定义绑定器，绑定到哪个消息中间件上
          binders:
            itheima_binder: # 自定义的绑定器名称
              type: rabbit # 绑定器类型
              environment: # 指定mq的环境
                spring:
                  rabbitmq:
                    host: 192.168.110.75
                    port: 5672
                    username: guest
                    password: guest
                    virtual-host: /
          bindings:
            input: # channel名称
              binder: itheima_binder #指定使用哪一个binder
              destination: itheima_exchange # 消息目的地
    ```

  + 薪资接收类

    ```java
    import org.springframework.cloud.stream.annotation.EnableBinding;
    import org.springframework.cloud.stream.annotation.StreamListener;
    import org.springframework.cloud.stream.messaging.Sink;
    import org.springframework.messaging.Message;
    import org.springframework.stereotype.Component;
    
    /**
     * 消息接收类
     */
    @EnableBinding({Sink.class})
    @Component
    public class MessageListener {
    
        @StreamListener(Sink.INPUT)
        public void receive(Message message){
            System.out.println(message);
            System.out.println(message.getPayload());
        }
    }
    ```

## 9.链路追踪

+ Sleuth：其实是一个工具,它在整个分布式系统中能跟踪一个用户请求的过程，捕获这些跟踪数 据，就能构建微服务的整个调用链的视图，这是调试和监控微服务的关键工具。 
  + 耗时分析 
  + 可视化错误 
  + 链路优化

+ Zipkin：是 Twitter 的一个开源项目，它致力于收集服务的定时数据，以解决微服务架构中的延迟问题，包括数据的收集、存储、查找和展现。

  + 安装启动zipkin。 java –jar zipkin.jar 

    + 访问zipkin web界面。 http://localhost:9411/ 

  + 在服务提供方和消费方分别引入 sleuth 和 zipkin 依赖 ，引一个就可以

    + 依赖

        ```xml
        <!-- sleuth-zipkin -->
        <!--<dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-sleuth</artifactId>
        </dependency>-->

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
        ```

    + 配置文件

      ```yml
      server:
        port: 9000
      
      
      eureka:
        instance:
          hostname: localhost # 主机名
        client:
          service-url:
            defaultZone: http://localhost:8761/eureka
      
      spring:
        application:
          name: feign-consumer # 设置当前应用的名称。将来会在eureka中Application显示。将来需要使用该名称来获取路径
        zipkin:
          base-url: http://localhost:9411/  # 设置zipkin的服务端路径
      
        sleuth:
          sampler:
            probability: 1 # 采集率 默认 0.1 百分之十。
      
      logging:
        level:
          com.itheima: debug
      ```

      

  + 分别配置服务提供方和消费方。 

  + 启动，测试