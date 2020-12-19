# SSM框架整合

## 1.目录结构

### 1.1 目录结构创建

+ src
    + java  =>  项目源代码		

      + controller  =>  表现层，XxxController.java
      + dao =>  数据持久层接口，XxxDao.interface

      + domain  =>  实体类
      + service
        + impl  => 业务层实现类，XxxServiceImpl.java
        + XxxService.interface  =>  业务层接口
      + system  =>  系统处理有关
        + exception  =>  系统异常处理类

    + resources  =>  配置文件

      + com.xxx.dao  =>  数据持久层映射xml
      + applicationContext.xml  =>  Spring配置
      + spring-mvc.xml  =>  SpringMVC配置
      + jdbc.properties  => JDBC连接配置 
      + log4j.properties  =>  log4j配置

    + webapp  =>  web资源目录
      + WEB-INF 
        + web.xml  =>  web配置
+ test 
    + java.com.xxx.service.XxxServiceTest  =>  业务层测试
    + resources  =>  测试配置，与项目区分开
+ target  =>  编译后的class文件
+ pom.xml  =>  Maven配置

### 1.2 相关依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>ssm</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <dependencies>
        <!--mybatis环境-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        <!--mysql环境-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--spring整合jdbc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
        <!--spring整合mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.3</version>
        </dependency>
        <!--druid连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.16</version>
        </dependency>
        <!--分页插件坐标-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.2</version>
        </dependency>
        <!--springmvc环境-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
        <!--jackson-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.0</version>
        </dependency>
        <!--servlet环境-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <!--junit单元测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <!--spring整合junit-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.1.9.RELEASE</version>
        </dependency>
		<!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.16</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <!-- 为当前模块配置私服，下载依赖 -->
    <repositories>
        <repository>
            <!-- 依赖仓库id，不可重复。repositories可以配置多个仓库，如果ID重复后面配置会覆盖之前的配置 -->
            <id>dependencies_Repositories</id>
            <!-- 私服仓库地址，即nexus仓库组的地址 -->
            <url>http://192.168.14.240:8081/repository/maven-public/</url>

            <!-- 是否下载releases构件 -->
            <releases>
                <enabled>true</enabled>
            </releases>

            <!-- 是否下载snapshots构件 -->
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <!-- 配置插件从私服下载 -->
    <pluginRepositories>
        <pluginRepository>
            <id>plugins_Repositories</id>
            <url>http://192.168.14.240:8081/repository/maven-public/</url>
            <!-- 是否下载release版本构件 -->
            <releases>
                <enabled>true</enabled>
            </releases>
            <!-- 是否下载snapshots版本构件 -->
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>

    <build>
        <plugins>
            <!-- Tomcat7的Maven插件 -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <path>/</path>
                    <port>80</port>
                    <server>tomcat7</server>
                    <uriEncoding>utf-8</uriEncoding>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <properties>
        <!-- 明确maven使用jdk1.8编译该模块 -->
        <project.build.sourceEncoding>utf-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>
```



## 2.配置MyBatis

### 2.1 相关文件创建

+ XxxDao.interface  =>  数据持久层接口

+ XxxDao.xml  =>  Mapper映射

+ 创建`DruidDataSource`，`SqlSessionFactoryBean`，`PageInterceptor`，`MapperScannerConfigurer`

  ```xml
  <!--数据源-->
  <context:property-placeholder location="classpath:jdbc.properties"/>
  
  <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
      <property name="driverClassName" value="${jdbc.driver}"/>
      <property name="url" value="${jdbc.url}"/>
      <property name="username" value="${jdbc.username}"/>
      <property name="password" value="${jdbc.password}"/>
  </bean>
  <!--配置MyBatis-->
  <bean class="org.mybatis.spring.SqlSessionFactoryBean">
      <property name="dataSource" ref="dataSource"/>
      <property name="typeAliasesPackage" value="com.itheima.domain"/>
      <!--配置分页插件-->
      <property name="plugins">
          <array>
              <bean class="com.github.pagehelper.PageInterceptor">
                  <property name="properties">
                      <props>
                          <prop key="helperDialect">mysql</prop>
                          <prop key="reasonable">true</prop>
                      </props>
                  </property>
              </bean>
          </array>
      </property>
  </bean>
  <!--配置映射文件扫描-->
  <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
      <property name="basePackage" value="com.itheima.dao"/>
  </bean>
  ```

## 3.配置Spring及Service层

### 3.1 相关文件创建

+ XxxService.interface  =>  业务层接口
+ impl.XxxServiceImpl.java  =>  业务层接口实现类

### 3.2 事务配置及Service实现

+ Spring注解扫描

  ```xml
  <context:component-scan base-package="com.itheima">
      <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  </context:component-scan>
  ```

+ 事务配置

  ```xml
  <!--事务-->
  <tx:annotation-driven transaction-manager="txManger"/>
  
  <bean id="txManger" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
      <property name="dataSource" ref="dataSource"/>
  </bean>
  ```

+ Service接口配置事务

  ```java
  @Transactional(readOnly = true)
  public interface XxxService {
  
      // 保存
      @Transactional(readOnly = false)
      boolean save(User user);
  
      // 更新
      @Transactional(readOnly = false)
      boolean update(User user);
      
      ...
  }
  ```

## 4.SpringMVC配置

### 4.1相关文件创建

+ XxxController.java  =>  表现层处理器
+ interceptor  =>  异常拦截器
+ result  =>  Restuful风格结果封装

### 4.2 SpringMVC配置

```xml
<!--注解扫描，只扫描controller包-->
<context:component-scan base-package="com.itheima.controller"/>
<!--注解驱动，以及响应编码处理-->
<mvc:annotation-driven>
    <mvc:message-converters>
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <constructor-arg value="utf-8"/>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
<!--放行静态资源-->
<mvc:default-servlet-handler/>
```

### 4.3 Web.xml配置

```xml
<!--配置监听器,用于加载SpringMVC-->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<!--Spring配置文件路径-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath*:applicationContext.xml</param-value>
</context-param>

<!--配置拦截器，解析请求中的参数_method，否则无法发起PUT请求与DELETE请求，配合页面表单使用-->
<filter>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <!-- 表示所有被DispatcherServlet处理的请求，都会经过该拦截器 -->
    <servlet-name>dispatcherServlet</servlet-name>
</filter-mapping>

<!--配置前端控制器-->
<servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--为当前servlet提供初始化参数-->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <!--指定项目启动时加载servlet-->
    <load-on-startup>1</load-on-startup>
</servlet>

<!--servlet映射-->
<servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>

<!--统一编码处理-->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

### 4.4 Controller层实现

+ Controller

```java
@RestController // 为Controller和ResponseBody的合体
@RequestMapping("/user") // 统一虚拟访问路径
public class UserController {

    @Autowired
    UserService userService;

    // 保存
    @PostMapping
    public Result save(User user){
        boolean save = userService.save(user);
        return new Result(save ? Code.SAVE_OK : Code.SAVE_ERR, null, null);
    }
    
    // 更新
    @PutMapping
    public Result update(User user){
        boolean update = userService.update(user);
        return new Result(update ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }
    
    ...
}
```

+ 注意事项：
  + 时间日期转换时，可以在实体类成员属性上通过`@DateTimeFormat(pattern = "yyyy-MM-dd")`指定时间日期格式
  + PUT请求参数放在URL里

+ 异常处理

  ```java
  @Component // 注册到SpringMVC
  @ControllerAdvice // 声名为异常处理类
  @ResponseBody // 满足Restuful风格
  public class ProjectExceptionAdvice {
  
      @ExceptionHandler(BusinessException.class)
      public Result doBusinessException(BusinessException be){
          return new Result(be.getCode(), null, be.getMessage());
      }
  
      @ExceptionHandler(SystemException.class)
      public Result doSystemException(SystemException se){
          return new Result(se.getCode(), null, se.getMessage());
      }
  }
  ```

+ 结果封装
  + 状态码
  + 数据
  + 消息

