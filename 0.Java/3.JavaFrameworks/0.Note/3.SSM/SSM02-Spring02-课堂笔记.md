## 注解的作用

目的是为了简化配置。

Spring的全注解开发，注解配置非常繁杂：

- 使用的是`SSM`开发的话，建议XML+注解进行配置

  XML负责配置第三方的类，注解配置自己定义的类。

- 使用的是`SpringBoot`开发，建议使用全注解



## 2. 常用注解

### ==2.1 注解使用步骤相关==

1. 开启组件扫描

   ```xml
   <!--启动组件扫描，指定对应扫描的包路径，该包及其子包下所有的类都会被扫描，加载包含指定注解的类-->
   <context:component-scan base-package="com.itheima"/>
   ```

2. 在要装配进Spring容器的类上添加注解

   ```java
   @Component("userService")  // 如果没有指定id，默认使用当前类名的首字母小写作为id
   public class UserServiceImpl implements UserService {}
   ```

3. 通过Spring容器对象获取bean对象并测试

   ```java
   // 略
   ```

4. 注解使用注意事项
   在进行组件所扫描时，会对配置的包及其子包中所有文件进行扫描
   扫描过程是以文件夹递归迭代的形式进行的
   扫描过程仅读取合法的java文件
   扫描时仅读取spring可识别的注解
   扫描结束后会将可识别的有效注解转化为spring对应的资源加入Spring容器

5. 组件扫描之排除

   ```xml
   <!--启动组件扫描，指定对应扫描的包路径，该包及其子包下所有的类都会被扫描，加载包含指定注解的类-->
   <context:component-scan base-package="com.itheima">
       <!-- 不扫描指定的内容 -->
       <!-- 排除标注有指定注解的类 -->
       <context:exclude-filter type="annotation"
                               expression="org.springframework.stereotype.Controller"/>
   
       <!-- 排除指定的包 -->
       <context:exclude-filter type="custom" expression="com.itheima.web"/>
   </context:component-scan>
   ```

   

### ==2.2 常用注解及功能==

| 注解                                 |          | 等同于                         | 作用                           | 备注                               |
| ------------------------------------ | -------- | ------------------------------ | ------------------------------ | ---------------------------------- |
| <font color="red">@Component</font>  | 类       | bean标签                       | 把当前类装配进Spring容器       | 默认以类名作为id<br>类名首字母小写 |
| <font color="red">@Controller</font> | 类       | bean标签                       | 同@Component                   | 语义化的@Component                 |
| <font color="red">@Service</font>    | 类       | bean标签                       | 同@Component                   | 语义化的@Component                 |
| <font color="red">@Repository</font> | 类       | bean标签                       | 同@Component                   | 语义化的@Component                 |
| <font color="red">@AutoWired</font>  | 属性     | `property[ref]`                | 从Spring容器中寻找对象注入     | 注入不依赖setter                   |
| <font color="red">@Value</font>      | 属性     | `property[value]``             | 为普通类型属性注入内容         | 注入不依赖setter                   |
| @Qualifier                           | 属性     | 配合@AutoWired实现按照名称注入 | 配合@AutoWired实现按照名称注入 |                                    |
| @Resource                            | 属性     | =@AutoWired + @Qulifier        | 按照名称注入                   | jdk9及以上版本默认不支持           |
| @Scope                               | 类       | bean标签scope属性              | bean的singleton\|prototype     | 默认Singleton                      |
| @PostConstruct                       | 方法     | `init-method`属性              | 标注初始化方法                 |                                    |
| @PreDestroy                          | 方法     | `destroy-method`               | 标注销毁方法                   | 多例销毁不受控制                   |
| @Primary                             | 方法     | property[index=0]              |                                |                                    |
| @Dependson                           | 类\|方法 |                                | 调整容器中bean的实例化顺序     |                                    |
| @Lazy                                | 类\|方法 |                                | 懒加载                         |                                    |
| @Order                               | 配置类   |                                | 调整配置类的加载顺序           |                                    |

### ==2.3 @AutoWired==

作用：按照类型注入

**运行原理**

，根据被 标注的属性的类型，从Spring容器中查找是否有符合要求的bean对象。

- 容器中有且只有一个符合类型要求的bean，直接注入
- 容器中有且存在多个符合类型要求的bean，会根据成员变量名和容器中的beanId进行匹配，匹配成功就注入
- 匹配失败，就报错，提示需要的类型有两个 ，名字分别是什么，但是我都用不了。

```java
@Autowired
private UserDao userDao;
```



### 2.4 @Qualifier 

作用：配合@AutoWired共同实现：按照名称注入



```java
@Autowired
@Qualifier("userDao")
private UserDao userDao;
```



### 2.5 @Resource

等同于`@Autowired + @Qualifier`，但是属于javax拓展包，Java9及以上版本默认不加载拓展包的依赖，需要手动添加才能用。



### ==2.6 工作中如何注入==

工作中，为当前类成员变量注入，使用`@Autowired`





### ==2.7 @Value==

- 注入普通类型是属性 基本类型 + String
- 可以配合SpELl读取配置文件中内容



## 3. 全注解开发Spring(理解)

### 常用注解及功能



| 注解                | 标注位置 | 等同于                                        | 作用                   | 备注               |
| ------------------- | -------- | --------------------------------------------- | ---------------------- | ------------------ |
| **@Bean**           | 方法     | `<bean>`                                      | 装配第三方的类         | 默认以方法名作为id |
| **@PropertySource** | 类       | `<context:property-placeholder location=""/>` | 引入properties配置文件 |                    |
| **@ComponentScan**  | 类       | `<context:component-scan package=""/>`        | 开启组件扫描           |                    |
| @Import             | 类       | `<import resource=""/>`                       | 导入分配置文件         | 有条件省略         |
| @Configuration      | 类       |                                               | 标注该类是一个配置类   | 有条件省略         |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |
|                     |          |                                               |                        |                    |



### ==3.1 @Bean==

作用：装配第三方类

定义一个方法，让方法的返回值是这个第三方类的对象；

方法定义在类中，要去类能被Spring识别，方法才能生效，所以要在类上加一个`@Component`（临时方案）

```java
@Component  //暂时方式，后期会调整
public class JDBCConfig {
    /**
     * @Bean 标注在方法上，会把当前方法的返回值装配进Spring容器，可以指定ID；
     * 如果没有指定id，以方法名作为id。
     * 通常情况下，我们的方法名会省略get，直接写dataSource
     * @return
     */
    // @Bean  这个时候，没有手动指定id，默认使用当前方法名作为id
    @Bean("dataSource")
    public static DruidDataSource dataSource(){
        
        // 读取properties配置文件
        
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
        ds.setUsername("root");
        ds.setPassword("itheima");
        return ds;
    }
}
```



> 注意：

连接四要素硬编码在Java代码中，可以手动读取properties配置文件，后者使用注解加载properties配置文件。

### ==3.2 @PropertySource==

作用：注解引入properties文件







### ==3.3 @ComponentScan==

作用：注解开启组件扫描

**配置类**   替代的 就是原来的   **配置文件**

@ComponentScan("basePackage")



- 不扫描指定内容

  ```java
  @ComponentScan(value = "com.itheima",
                 excludeFilters = {@ComponentScan.Filter({Controller.class})})
  @ComponentScan(value = "com.itheima",
                 excludeFilters = {
                     @ComponentScan.Filter(
                         type= FilterType.CUSTOM,
                         pattern = "com.itheima.web")})
  public class SpringConfig {}
  ```

  

  

  

- 排除指定内容，不加载进Spring容器

  ```java
  // 排除标注有指定注解的类
  //<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  //@ComponentScan(value = "com.itheima",excludeFilters =
  //            @ComponentScan.Filter({Controller.class, Service.class}))
  
  // 排除指定的包
  //  <context:exclude-filter type="custom" expression="com.itheima.web"/>
  @ComponentScan(value = "com.itheima",
          excludeFilters=@ComponentScan.Filter(type = FilterType.CUSTOM,
                                              pattern = "com.itheima.web"))
  ```

  

  

### 3.5 @import(可选)

引入Spring其他分的配置类

把数据库相关的内容分出去，dao内容分出去，

可以在一个配置类上通过该注解引入其他配置类，这个时候当前配置类可以被称为主的配置类，其他为分的配置类；在创建Spring容器的时候，可以只指定主配置类；

```java
 ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class)
```

也可以指定全部配置类（这个时候就没有了主、分的概念）

```java
 ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class,JdbcConfig.class)
```







### 3.6 @Configuration(可选)

标注在类上，表示当前类是一个注解类，可以省略不写，只需要在创建容器对象的时候指定即可。





## ==4. 全注解整合Mybatis==

### 1. 导入依赖坐标

```xml
// 同xml配置
```



### 2. 新建并配置主配置类

该配置类为主配置类，之后要导入其他分配置类，导入方式：` @Import({A.class,B.class})`

```java
@Configuration
@ComponentScan("com.itheima")
// @Import({JDBCConfig.class,MyBatisConfig.class})
public class SpringConfig {
}
```



### 3. 新建并配置jdbc配置类

该配置类为JDBC相关分配置类，要被导入到主配置类

```java
@PropertySource("classpath:jdbc.properties")
public class JDBCConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
```



`jdbc.properties`

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring_db
jdbc.username=root
jdbc.password=root
```



### 4. 新建并配置Mybatis配置类

该配置类为Mybatis相关分配置类，要被导入到主配置类

```java
//@PropertySource("mybatis.properties")
public class MyBatisConfig {

    //@Value("${mybatis.xxx}")
    //String typeAliasBasePage;
    //@Value("${mybatis.yyy}")
    //String scannerBasePage;


    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima.domain");
        //ssfb.setTypeAliasesPackage(typeAliasBasePage);
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        //msc.setBasePackage(scannerBasePage);
        return msc;
    }
}
```



### 5. 测试

在App类中的main方法中测试

```java
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        Account ac = accountService.findById(2);
        System.out.println(ac);
    }
}
```



## 5. Spring整合junit(理解)

目的：简化Spring单元测试

### 1. 导入依赖坐标

```xml
<!-- junit version ≥ 4.12 -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
<!-- spring整合junit的依赖 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.1.9.RELEASE</version>
</dependency>
```

### 2. 使用Spring专用的类加载器

写一个测试类，在测试类上添加`@RunWith(SpringJUnit4ClassRunner.class)`

```java
//设定spring专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {}
```

### 3. 加载配置类/配置文件

在上面的测试类上添加注解，`@ContextConfiguration(配置文件或者配置类)`

```java
//设定spring专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
//设定加载的spring上下文对应的配置
@ContextConfiguration(classes = SpringConfig.class)
//设定加载的spring上下文对应的配置
//@ContextConfiguration(classes = SpringConfig.class)
//@ContextConfiguration(value = {"classpath:配置文件1.xml","classpath:配置文件2.xml"})
//@ContextConfiguration(locations = {"classpath:配置文件1.xml","classpath:配置文件2.xml"})
//@ContextConfiguration(locations = "classpath:配置文件1.xml")
public class UserServiceTest {}
```



`@ContextConfiguration`注解源码

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ContextConfiguration {
    // 该属性用于指定配置文件的数组
    @AliasFor("locations")
    String[] value() default {};
    
	// 该属性用于指定配置文件的数组
    @AliasFor("value")
    String[] locations() default {};

    // 该属性用于指定配置类的字节码对象的数组
    Class<?>[] classes() default {};
}
```



### 4. 测试类中注入要被测试的类

```java
//设定spring专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
//设定加载的spring上下文对应的配置
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    // 想测谁，就注入谁
    @Autowired
    private AccountService accountService;
    
    @Test
    public void testFindById() {
        Account ac = accountService.findById(2);
        Assert.assertEquals("Jock1", ac.getName());
    }
}
```







### 5. 完整代码

```java
package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//设定spring专用的类加载器
@RunWith(SpringJUnit4ClassRunner.class)
//设定加载的spring上下文对应的配置
@ContextConfiguration(classes = SpringConfig.class)
//@ContextConfiguration(value = {"classpath:配置文件1.xml","classpath:配置文件2.xml"})
//@ContextConfiguration(locations = {"classpath:配置文件1.xml","classpath:配置文件2.xml"})
//@ContextConfiguration(locations = "classpath:配置文件1.xml")
public class UserServiceTest {

    // 想测谁，就注入谁
    @Autowired
    private AccountService accountService;

    // 这里可能会报错，但是不要理会，不是语法错误，是spring帮你检查当前spring容器中是否有类的对象，不一定准确
    @Autowired
    AccountDao accountDao;

    @Test
    public void testFindById() {
        Account ac = accountService.findById(2);
//        System.out.println(ac);
        Assert.assertEquals("Jock1", ac.getName());
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAll();
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testDao() {
        accountDao.findAll();
    }
}
```







## 6. IoC底层核心原理

学顶层（接口），用底层（实现类）



### 6.1 子父容器

```shell
- dao层容器
|- service层容器
    |- web层容器
    
web层容器的范围最大，可以使用另外两层中已经装配好的bean对象
```



### 6.2  不加载指定的内容

- **过滤策略(5种)**

  

- **排除指定注解**

  > 

  

- **自定义排除规则**

  编写一个类实现TypeFilter

- **应用场景**

  SpringMVC装配web层bean

  Spring装配service和dao层的bean

配置



### 6.3 自定义组件扫描器







### 6.4 Bean的初始化过程

初始化工厂

工厂的后置处理器`BeanFactoryPostProcessor`



创建Bean对象  new Object();  // 属性未赋值

Bean的后置处理器前

init-method

Bean的后置处理器后

初始化Bean对象对象    // 为属性赋值

// 使用对象

destroy-method





**面试题**

- BeanFactory  FactoryBean什么区别
  - BeanFactory是Spring容器的顶层接口，里面规定了一些基础的方法，getBean()
  - **Factory**Bean，如果某个bean的对象创建过程比较复杂，我们可以使用工厂的模式创建这个Bean对象，这个时候可以实现FactoryBean接口。

