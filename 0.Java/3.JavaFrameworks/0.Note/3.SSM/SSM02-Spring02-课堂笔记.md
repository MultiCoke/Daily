## ע�������

Ŀ����Ϊ�˼����á�

Spring��ȫע�⿪����ע�����÷ǳ����ӣ�

- ʹ�õ���`SSM`�����Ļ�������XML+ע���������

  XML�������õ��������࣬ע�������Լ�������ࡣ

- ʹ�õ���`SpringBoot`����������ʹ��ȫע��



## 2. ����ע��

### ==2.1 ע��ʹ�ò������==

1. �������ɨ��

   ```xml
   <!--�������ɨ�裬ָ����Ӧɨ��İ�·�����ð������Ӱ������е��඼�ᱻɨ�裬���ذ���ָ��ע�����-->
   <context:component-scan base-package="com.itheima"/>
   ```

2. ��Ҫװ���Spring�������������ע��

   ```java
   @Component("userService")  // ���û��ָ��id��Ĭ��ʹ�õ�ǰ����������ĸСд��Ϊid
   public class UserServiceImpl implements UserService {}
   ```

3. ͨ��Spring���������ȡbean���󲢲���

   ```java
   // ��
   ```

4. ע��ʹ��ע������
   �ڽ��������ɨ��ʱ��������õİ������Ӱ��������ļ�����ɨ��
   ɨ����������ļ��еݹ��������ʽ���е�
   ɨ����̽���ȡ�Ϸ���java�ļ�
   ɨ��ʱ����ȡspring��ʶ���ע��
   ɨ�������Ὣ��ʶ�����Чע��ת��Ϊspring��Ӧ����Դ����Spring����

5. ���ɨ��֮�ų�

   ```xml
   <!--�������ɨ�裬ָ����Ӧɨ��İ�·�����ð������Ӱ������е��඼�ᱻɨ�裬���ذ���ָ��ע�����-->
   <context:component-scan base-package="com.itheima">
       <!-- ��ɨ��ָ�������� -->
       <!-- �ų���ע��ָ��ע����� -->
       <context:exclude-filter type="annotation"
                               expression="org.springframework.stereotype.Controller"/>
   
       <!-- �ų�ָ���İ� -->
       <context:exclude-filter type="custom" expression="com.itheima.web"/>
   </context:component-scan>
   ```

   

### ==2.2 ����ע�⼰����==

| ע��                                 |          | ��ͬ��                         | ����                           | ��ע                               |
| ------------------------------------ | -------- | ------------------------------ | ------------------------------ | ---------------------------------- |
| <font color="red">@Component</font>  | ��       | bean��ǩ                       | �ѵ�ǰ��װ���Spring����       | Ĭ����������Ϊid<br>��������ĸСд |
| <font color="red">@Controller</font> | ��       | bean��ǩ                       | ͬ@Component                   | ���廯��@Component                 |
| <font color="red">@Service</font>    | ��       | bean��ǩ                       | ͬ@Component                   | ���廯��@Component                 |
| <font color="red">@Repository</font> | ��       | bean��ǩ                       | ͬ@Component                   | ���廯��@Component                 |
| <font color="red">@AutoWired</font>  | ����     | `property[ref]`                | ��Spring������Ѱ�Ҷ���ע��     | ע�벻����setter                   |
| <font color="red">@Value</font>      | ����     | `property[value]``             | Ϊ��ͨ��������ע������         | ע�벻����setter                   |
| @Qualifier                           | ����     | ���@AutoWiredʵ�ְ�������ע�� | ���@AutoWiredʵ�ְ�������ע�� |                                    |
| @Resource                            | ����     | =@AutoWired + @Qulifier        | ��������ע��                   | jdk9�����ϰ汾Ĭ�ϲ�֧��           |
| @Scope                               | ��       | bean��ǩscope����              | bean��singleton\|prototype     | Ĭ��Singleton                      |
| @PostConstruct                       | ����     | `init-method`����              | ��ע��ʼ������                 |                                    |
| @PreDestroy                          | ����     | `destroy-method`               | ��ע���ٷ���                   | �������ٲ��ܿ���                   |
| @Primary                             | ����     | property[index=0]              |                                |                                    |
| @Dependson                           | ��\|���� |                                | ����������bean��ʵ����˳��     |                                    |
| @Lazy                                | ��\|���� |                                | ������                         |                                    |
| @Order                               | ������   |                                | ����������ļ���˳��           |                                    |

### ==2.3 @AutoWired==

���ã���������ע��

**����ԭ��**

�����ݱ� ��ע�����Ե����ͣ���Spring�����в����Ƿ��з���Ҫ���bean����

- ����������ֻ��һ����������Ҫ���bean��ֱ��ע��
- ���������Ҵ��ڶ����������Ҫ���bean������ݳ�Ա�������������е�beanId����ƥ�䣬ƥ��ɹ���ע��
- ƥ��ʧ�ܣ��ͱ�����ʾ��Ҫ������������ �����ֱַ���ʲô�������Ҷ��ò��ˡ�

```java
@Autowired
private UserDao userDao;
```



### 2.4 @Qualifier 

���ã����@AutoWired��ͬʵ�֣���������ע��



```java
@Autowired
@Qualifier("userDao")
private UserDao userDao;
```



### 2.5 @Resource

��ͬ��`@Autowired + @Qualifier`����������javax��չ����Java9�����ϰ汾Ĭ�ϲ�������չ������������Ҫ�ֶ���Ӳ����á�



### ==2.6 ���������ע��==

�����У�Ϊ��ǰ���Ա����ע�룬ʹ��`@Autowired`





### ==2.7 @Value==

- ע����ͨ���������� �������� + String
- �������SpELl��ȡ�����ļ�������



## 3. ȫע�⿪��Spring(���)

### ����ע�⼰����



| ע��                | ��עλ�� | ��ͬ��                                        | ����                   | ��ע               |
| ------------------- | -------- | --------------------------------------------- | ---------------------- | ------------------ |
| **@Bean**           | ����     | `<bean>`                                      | װ�����������         | Ĭ���Է�������Ϊid |
| **@PropertySource** | ��       | `<context:property-placeholder location=""/>` | ����properties�����ļ� |                    |
| **@ComponentScan**  | ��       | `<context:component-scan package=""/>`        | �������ɨ��           |                    |
| @Import             | ��       | `<import resource=""/>`                       | ����������ļ�         | ������ʡ��         |
| @Configuration      | ��       |                                               | ��ע������һ��������   | ������ʡ��         |
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

���ã�װ���������

����һ���������÷����ķ���ֵ�������������Ķ���

�������������У�Ҫȥ���ܱ�Springʶ�𣬷���������Ч������Ҫ�����ϼ�һ��`@Component`����ʱ������

```java
@Component  //��ʱ��ʽ�����ڻ����
public class JDBCConfig {
    /**
     * @Bean ��ע�ڷ����ϣ���ѵ�ǰ�����ķ���ֵװ���Spring����������ָ��ID��
     * ���û��ָ��id���Է�������Ϊid��
     * ͨ������£����ǵķ�������ʡ��get��ֱ��дdataSource
     * @return
     */
    // @Bean  ���ʱ��û���ֶ�ָ��id��Ĭ��ʹ�õ�ǰ��������Ϊid
    @Bean("dataSource")
    public static DruidDataSource dataSource(){
        
        // ��ȡproperties�����ļ�
        
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
        ds.setUsername("root");
        ds.setPassword("itheima");
        return ds;
    }
}
```



> ע�⣺

������Ҫ��Ӳ������Java�����У������ֶ���ȡproperties�����ļ�������ʹ��ע�����properties�����ļ���

### ==3.2 @PropertySource==

���ã�ע������properties�ļ�







### ==3.3 @ComponentScan==

���ã�ע�⿪�����ɨ��

**������**   ����� ����ԭ����   **�����ļ�**

@ComponentScan("basePackage")



- ��ɨ��ָ������

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

  

  

  

- �ų�ָ�����ݣ������ؽ�Spring����

  ```java
  // �ų���ע��ָ��ע�����
  //<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  //@ComponentScan(value = "com.itheima",excludeFilters =
  //            @ComponentScan.Filter({Controller.class, Service.class}))
  
  // �ų�ָ���İ�
  //  <context:exclude-filter type="custom" expression="com.itheima.web"/>
  @ComponentScan(value = "com.itheima",
          excludeFilters=@ComponentScan.Filter(type = FilterType.CUSTOM,
                                              pattern = "com.itheima.web"))
  ```

  

  

### 3.5 @import(��ѡ)

����Spring�����ֵ�������

�����ݿ���ص����ݷֳ�ȥ��dao���ݷֳ�ȥ��

������һ����������ͨ����ע���������������࣬���ʱ��ǰ��������Ա���Ϊ���������࣬����Ϊ�ֵ������ࣻ�ڴ���Spring������ʱ�򣬿���ָֻ���������ࣻ

```java
 ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class)
```

Ҳ����ָ��ȫ�������ࣨ���ʱ���û���������ֵĸ��

```java
 ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class,JdbcConfig.class)
```







### 3.6 @Configuration(��ѡ)

��ע�����ϣ���ʾ��ǰ����һ��ע���࣬����ʡ�Բ�д��ֻ��Ҫ�ڴ������������ʱ��ָ�����ɡ�





## ==4. ȫע������Mybatis==

### 1. ������������

```xml
// ͬxml����
```



### 2. �½���������������

��������Ϊ�������֮࣬��Ҫ���������������࣬���뷽ʽ��` @Import({A.class,B.class})`

```java
@Configuration
@ComponentScan("com.itheima")
// @Import({JDBCConfig.class,MyBatisConfig.class})
public class SpringConfig {
}
```



### 3. �½�������jdbc������

��������ΪJDBC��ط������࣬Ҫ�����뵽��������

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



### 4. �½�������Mybatis������

��������ΪMybatis��ط������࣬Ҫ�����뵽��������

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



### 5. ����

��App���е�main�����в���

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



## 5. Spring����junit(���)

Ŀ�ģ���Spring��Ԫ����

### 1. ������������

```xml
<!-- junit version �� 4.12 -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
<!-- spring����junit������ -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.1.9.RELEASE</version>
</dependency>
```

### 2. ʹ��Springר�õ��������

дһ�������࣬�ڲ����������`@RunWith(SpringJUnit4ClassRunner.class)`

```java
//�趨springר�õ��������
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {}
```

### 3. ����������/�����ļ�

������Ĳ����������ע�⣬`@ContextConfiguration(�����ļ�����������)`

```java
//�趨springר�õ��������
@RunWith(SpringJUnit4ClassRunner.class)
//�趨���ص�spring�����Ķ�Ӧ������
@ContextConfiguration(classes = SpringConfig.class)
//�趨���ص�spring�����Ķ�Ӧ������
//@ContextConfiguration(classes = SpringConfig.class)
//@ContextConfiguration(value = {"classpath:�����ļ�1.xml","classpath:�����ļ�2.xml"})
//@ContextConfiguration(locations = {"classpath:�����ļ�1.xml","classpath:�����ļ�2.xml"})
//@ContextConfiguration(locations = "classpath:�����ļ�1.xml")
public class UserServiceTest {}
```



`@ContextConfiguration`ע��Դ��

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ContextConfiguration {
    // ����������ָ�������ļ�������
    @AliasFor("locations")
    String[] value() default {};
    
	// ����������ָ�������ļ�������
    @AliasFor("value")
    String[] locations() default {};

    // ����������ָ����������ֽ�����������
    Class<?>[] classes() default {};
}
```



### 4. ��������ע��Ҫ�����Ե���

```java
//�趨springר�õ��������
@RunWith(SpringJUnit4ClassRunner.class)
//�趨���ص�spring�����Ķ�Ӧ������
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    // ���˭����ע��˭
    @Autowired
    private AccountService accountService;
    
    @Test
    public void testFindById() {
        Account ac = accountService.findById(2);
        Assert.assertEquals("Jock1", ac.getName());
    }
}
```







### 5. ��������

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

//�趨springר�õ��������
@RunWith(SpringJUnit4ClassRunner.class)
//�趨���ص�spring�����Ķ�Ӧ������
@ContextConfiguration(classes = SpringConfig.class)
//@ContextConfiguration(value = {"classpath:�����ļ�1.xml","classpath:�����ļ�2.xml"})
//@ContextConfiguration(locations = {"classpath:�����ļ�1.xml","classpath:�����ļ�2.xml"})
//@ContextConfiguration(locations = "classpath:�����ļ�1.xml")
public class UserServiceTest {

    // ���˭����ע��˭
    @Autowired
    private AccountService accountService;

    // ������ܻᱨ�����ǲ�Ҫ��ᣬ�����﷨������spring�����鵱ǰspring�������Ƿ�����Ķ��󣬲�һ��׼ȷ
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







## 6. IoC�ײ����ԭ��

ѧ���㣨�ӿڣ����õײ㣨ʵ���ࣩ



### 6.1 �Ӹ�����

```shell
- dao������
|- service������
    |- web������
    
web�������ķ�Χ��󣬿���ʹ�������������Ѿ�װ��õ�bean����
```



### 6.2  ������ָ��������

- **���˲���(5��)**

  

- **�ų�ָ��ע��**

  > 

  

- **�Զ����ų�����**

  ��дһ����ʵ��TypeFilter

- **Ӧ�ó���**

  SpringMVCװ��web��bean

  Springװ��service��dao���bean

����



### 6.3 �Զ������ɨ����







### 6.4 Bean�ĳ�ʼ������

��ʼ������

�����ĺ��ô�����`BeanFactoryPostProcessor`



����Bean����  new Object();  // ����δ��ֵ

Bean�ĺ��ô�����ǰ

init-method

Bean�ĺ��ô�������

��ʼ��Bean�������    // Ϊ���Ը�ֵ

// ʹ�ö���

destroy-method





**������**

- BeanFactory  FactoryBeanʲô����
  - BeanFactory��Spring�����Ķ���ӿڣ�����涨��һЩ�����ķ�����getBean()
  - **Factory**Bean�����ĳ��bean�Ķ��󴴽����̱Ƚϸ��ӣ����ǿ���ʹ�ù�����ģʽ�������Bean�������ʱ�����ʵ��FactoryBean�ӿڡ�

