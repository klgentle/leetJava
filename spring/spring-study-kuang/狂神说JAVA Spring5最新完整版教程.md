#  狂神说JAVA Spring5最新完整版教程

## 1 Spring

### 1.1 简介

2002首次推出spring框架的雏形，interface21框架

Rod Johnson Spring Framework创始人，是悉尼大学的博士，**专业是音乐学**。

SSH: Struct2 + Spring + Hibernate!

SSM: SpringMvc + Spring + Mybatis!

官网：https://spring.io/projects/spring-framework

官方下载地址：https://repo.spring.io/release/org/springframework/spring/

GitHub:https://github.com/spring-projects/spring-framework

<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->

<dependency>

​    <groupId>org.springframework</groupId>

​    <artifactId>spring-webmvc</artifactId>

​    <version>5.2.0.RELEASE</version>

</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->

<dependency>

​    <groupId>org.springframework</groupId>

​    <artifactId>spring-jdbc</artifactId>

​    <version>5.2.0.RELEASE</version>

</dependency>

### 1.2 优点

开源免费

轻量级

**控制反转（IOC），面向切面（AOP）**

支持事务的处理 ，对构架整合的支持

p2

### 1.3 组成

![img](D:\ProgramData\note_of_youdao\sina1897731780\4058425db4f5485283308fbec4b482e8\clipboard.png)

![img](D:\ProgramData\note_of_youdao\sina1897731780\067cd5dfd2c84b10b00dec6be5167398\clipboard.png)

### 1.4 拓展

Spring Boot

一个快速开发的脚手架

可以快速开发单个微服务

约定大于配置

Spring Cloud

基于Spring Boot实现的

学习Spring Boot 需要完全掌握Spring和SpringMVC

弊端：**配置地狱**

**p3 **

## 2 IOC理论推导

传统的java代码编写过程如下：

UserDao 接口

UserDaoImpl 实现类

UserService 业务接口

UserServiceImp 业务实现类

在UserServiceImp 业务实现类中需要使用set方法，不然用户修改需求之后要修改代码

private userDao userDao;

//利用set进行动态注入

public void setUserDao(UserDao userDao) {

this.userDao = UserDao;

}

TODO 练习ioc

**public class** **MyTest** {

​    **public static void** main (**String**[] args) {

​        UserService service = **new** UserServiceImpl();

​        service.getUser();

​    }

}

**P4 IOC本质**

Inversion 倒置，颠倒

控制反转IoC(Inversion of Control), 是一种设计思想，DI(依赖注入)是实现IoC的一种方式。

控制反转是一种通过描述（XML或注解）并**通过第三方**去生产或获取特定对象的方式。

**p5 **

## 3 HelloSpring

<beans.xml>

id = 变量名

class = new 的对象

property 相当于给对象中的属性设置一个值

<bean id="hello" class="com.kuang.pojo.Hello">

<property name="str" value="Sprnig"/>

</bean>

所谓的**IoC**,一句话搞定：对象由Spring来创建，管理，装配。

写applicationContext.xml建议去官网抄一个最新的，地址如下：

https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#spring-core

<?xml version="1.0" encoding="UTF-8"?> <beans xmlns="http://www.springframework.org/schema/beans"    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"    xsi:schemaLocation="http://www.springframework.org/schema/beans        https://www.springframework.org/schema/beans/spring-beans.xsd">     <bean id="..." class="...">          <!-- collaborators and configuration for this bean go here -->    </bean>    <!-- more bean definitions go here --> </beans>

public class MyTest {

​    public static void main (String[] args) {

​        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

​        UserService userService = (UserServiceImpl) context.getBean("userServiceImpl");

​        userService.getUser();

​    }

}

applicateContext配置文件可以使用其它名字，如beans.xml, 应该放在src/main/resources目录下，不然不会生效

![img](D:\ProgramData\note_of_youdao\sina1897731780\c90eda13ff1f43daa69ea547c9fc36ed\clipboard.png)

**P6 **

## 4 IOC对象创建方式

1.使用无参构造创建对象，默认！

2.使用参数构造创建对象

- 下标赋值

<bean id="user" class="com.kuang.pojo.User">

<constructor-arg index="0" value="狂神说Java">

</bean>

- type matching 不建议使用

<bean id="exampleBean" class="examples.ExampleBean">    	<constructor-arg type="int" value="7500000"/>    	<constructor-arg type="java.lang.String" value="42"/>

</bean>

- Contractor argument name

<bean id="exampleBean" class="examples.ExampleBean">    	<constructor-arg name="years" value="7500000"/>    	<constructor-arg name="ultimateAnswer" value="42"/>

</bean>

总结：在配置文件加载的时候，容器中管理的对象就已经初始化了。

（不管你想不想看到，它就在那里）

**P7 **

## 5 Spring配置说明

![img](D:\ProgramData\note_of_youdao\sina1897731780\9817b687e99a47b3af01f6f190b234d3\clipboard.png)

配置文件可以有多个，然后使用import导入其他配置文件

<import resource="beans.xml" />

**P8 **

## 6 DI依赖注入

**P9 依赖注入Set注入（重点）**

完善注入信息

<bean id="address" class="com.klgentle.pojo.Address">

​        <property name="address" value="China"/>

​    </bean>

​    <bean id="student" class="com.klgentle.pojo.Student" >

​        <property name="name" value="CuteSmile"/>

​        <property name="address" ref="address"/>

​        <!-- 数组-->

​        <property name="books">

​            <array>

​                <value>红楼梦</value>

​                <value>三国演义</value>

​                <value>金瓶梅</value>

​            </array>

​        </property>

​        <!--list -->

​        <property name="hobbys">

​            <list>

​                <value>swing</value>

​                <value>pingpong</value>

​                <value>golf</value>

​            </list>

​        </property>

​        <!--Map -->

​        <property name="card">

​            <map>

​                <entry key="0001" value="nana">

​                </entry>

​                <entry key="0002" value="kulokanxi">

​                </entry>

​                <entry key="0003" value="slsl">

​                </entry>

​            </map>

​        </property>

​        <!-- Set-->

​        <property name="games" >

​            <set>

​                <value>LOL</value>

​                <value>BOB</value>

​                <value>COC</value>

​            </set>

​        </property>

​        <!-- null-->

​        <property name="wife" >

​            <null/>

​        </property>

​        <property name="info">

​            <props>

​                <prop key="kl">klgentle</prop>

​                <prop key="sl">slgentle</prop>

​            </props>

​        </property>

​    </bean>

**P10 命名空间注入**

网址访问不了 http://www.springframework.org/schema/p

跳过这一节

**P11 6.4 bean的作用域**

![img](D:\ProgramData\note_of_youdao\sina1897731780\e1dbe8dc1ef74926845f5f679a93592a\clipboard.png)

singleton Spring的默认模式

![img](D:\ProgramData\note_of_youdao\sina1897731780\c69c10d5030d4debb0b32513de34b6fa\clipboard.png)

prototype模式，每次get得到的对象都是不同的。

sope="prototype"

**p12 **

 ## 7 bean的自动装配

Spring会在上下文中自动寻找，自动装配。

三种装配方式：

1. xml显示
2. java显示
3. 隐式的自动装配bean【**重要**】

环境搭建：一个人有两个宠物

### byName自动装配

<!-- byName 查找 set方法后面的beanid-->

<**bean** id="people" class="com.klgentle.pojo.People" autowire="byName">

​    <**property** name="name" value="可爱的小gentle啊"/>

</**bean**>

### byType自动装配

<**bean** class="com.klgentle.pojo.Cat"/>

<**bean** id="2dog" class="com.klgentle.pojo.Dog"/>

<!-- byType 查找属性类型相同的bean

-->

<**bean** id="people" class="com.klgentle.pojo.People" autowire="byType">

​    <**property** name="name" value="可爱的小gentle啊"/>

</**bean**>

小结：

byName的时候，需要保证**bean的id唯一**，并且跟类中的set方法一致

byType的时候，需要保证**class唯一**，并且跟属性的类型一致

**P13注解实现自动装配**

## 8 使用注解开发

The introduction of annotation-based configuration raised the question of whether this

approach is “better” than XML. The short answer is “it depends.”

使用注解须知：

- 导入约束 context约束
- 配置注解的支持  **<context:annotation-config/> [****重要****]**

使用自动装配的配置：

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"

 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

 **xmlns:context="http://www.springframework.org/schema/context"**

 xsi:schemaLocation="http://www.springframework.org/schema/beans

 https://www.springframework.org/schema/beans/spring-beans.xsd

 http://www.springframework.org/schema/context

 https://www.springframework.org/schema/context/spring-context.xsd">

 **<context:annotation-config/>**

</beans>

**@Autowired** 

可以直接在属性上使用,也可以在set方法上使用。

在属性上使用后可以省略set方法，前提是在IOC容器中存在，且符合byName要求。

科普：

@Nullable annotation 可以允许字段为空

**public** @**interface** Autowired {

​    **boolean** required() **default true**;

}

// required = false 说明属性可以为空

@Autowired(required = false) 

如果配置比较复杂，无法单独根据byName,或者byType获取，可以使用@Qualifier(value = beanId) 指定beanId

@Autowired

@Qualifier(value = "dog22")

或者使用java 的 @Resource

@Resource

**private** **Cat** cat;

 

@Resource(name="cat2")

小结：

@Resource和@Autowired的区别

都是用来自动装配的，都可以放在属性字段上

@Autowired通过byType的方式实现，而且必须要求这个对象存在。

@Resource默认通过byName的方式实现，如果失败，则通过byType方式

执行顺序不同：@Autowired通过byType方式实现， @Resource默认通过byName的方式实现

**P14 使用注解开发**

C8 

在spring4之后，要使用注解开发必须要导入aop包

![img](D:\ProgramData\note_of_youdao\sina1897731780\756668a7d8304a85ae3671d4210e18a2\clipboard.png)

1. bean
2. 属性如何注入

// 等价于 <bean id="user" class="..."/>

@Component

**public class** **User** {

​    @Value("klgentle")

​    **public** **String** name;

}

1. 衍生的注解

@Component 有几个衍生注解，如在web开发中,会按MVC三层架构分层

dao 【@Repository】

service 【@Service】

controller 【@Controller】

这四个功能都是一样的，都是代表将类注册到Spring，装配bean.

1. 自动装配

@Autowired: 自动装配通过类型，名字

@Nullable 字段标记了这个注解，说明这个字段可以为null;

@Resource 自动装配通过名字，类型。

1. 作用域

@Component

@Scope("prototype")

**public class** **User** {

​    @Value("klgentle")

​    **public** **String** name;

}

1. 小结

xml更加万能，适用于任何场合，维护简单方便

注解，不是自己的类无法使用，维护相对复杂

**最佳实践**

xml用来管理bean;

注解只完成属性的注入

注意，要使用注解，要开启注解支持

**P15 使用JavaConfig实现配置**

## 9 使用Java的方式

文档 1.12. Java-based Container Configuration

![img](D:\ProgramData\note_of_youdao\sina1897731780\5bbee8d3d54745038d7189a2fb07b14c\clipboard.png)

User.java

// @Component 说明这个类被Spring接管了，注册到了容器中 @Component public class User {    @Value("KLGENTLE")    private String name;     public String getName() {        return name;    }     public void setName(String name) {        this.name = name;    }     @Override    public String toString() {        return "User{" +                "name='" + name + '\'' +                '}';    } }

MyConfig.java

package com.klgentle.config; import com.klgentle.pojo.User; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.ComponentScan; import org.springframework.context.annotation.Configuration; import org.springframework.context.annotation.Import; // @Configuration 会被Spring管理，注册到容器中 // @Configuration 代表这是一个配置类，类似于beans.xml @Configuration @ComponentScan("com.klgentle.pojo") @Import(KlgentleConfig.class) public class MyConfig {     @Bean // 注册一个bean， 相当于一个bean标签    public User user() {        return new User();    } }

MyTest.java

public class MyTest {    public static void main(String[] args) {        // 如果完全通过配置类来做，只能使用 AnnotationConfig 上下文获取容器        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);        User user = (User) context.getBean("user");        System.out.println(user.getName());    } }

这种纯JAVA的配置，在SpringBoot中随处可见。

**P16 静态代理模式**

## 10 代理模式

代理模式是AOP的底层

【Spring AOP Spring MVC】面试必问

### 代理分类：

- 静态代理
- 动态代理

![img](D:\ProgramData\note_of_youdao\sina1897731780\5ea0e289e0f64dd89c6e5aff4609d388\clipboard.png)

### 角色分析：

- 抽象角色：一般会使用接口或者抽象类来实现
- 真实角色：被代理的角色
- 代理角色：代理真实角色，代理真实角色后，一般会做一些附属操作
- 客户：访问代理对象的人。

### 代码步骤：

1、接口

2、真实角色

3、代理角色

4、客户端访问代理角色

### 10.1  静态代理

代理模式的好处：

- 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务
- 公共业务交给代理角色，实现了业务的分工。
- 公共业务发生扩展的时候，方便集中管理。

缺点：

- 一个真实角色会产生一个代理类，代码量会翻倍

**P18 静态代理再理解**

### 10.2 加深理解

代码08-demo02

聊聊AOP 

![img](D:\ProgramData\note_of_youdao\sina1897731780\5f2a2184ab8d4aff87b938b870295b7f\clipboard.png)

**P19 动态代理详解**

### 10.3 动态代理

动态代理和静态代理角色一样

动态代理是动态生成的，不是我们直接写好的。

动态代理分为两大类：基于接口的，基于类的

基于接口--jdk动态代理 【我们在这里使用】

基于类：cglib

java字节码实现:javasis

需要了解两个类：Proxy 代理, InvocationHandler 调用处理程序

jdk api 1.8_google 文档

InvocationHandler 

动态代理的好处：

一个动态代理类代理的是一个接口，一般就是对应的一类业务

一个动态代理类可以代理多个类，

**P20 AOP 实现方式一**

## 11 AOP

### 11.1 什么是AOP

AOP为Aspect Oriented Programming的缩写，意为：[面向切面编程](https://baike.baidu.com/item/面向切面编程/6016335)，通过[预编译](https://baike.baidu.com/item/预编译/3191547)方式和运行期间动态代理实现程序功能的统一维护的一种技术。AOP是[OOP](https://baike.baidu.com/item/OOP)的延续，是软件开发中的一个热点，也是[Spring](https://baike.baidu.com/item/Spring)框架中的一个重要内容，是[函数式编程](https://baike.baidu.com/item/函数式编程/4035031)的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的[耦合度](https://baike.baidu.com/item/耦合度/2603938)降低，提高程序的可重用性，同时提高了开发的效率。

![img](D:\ProgramData\note_of_youdao\sina1897731780\a7d4bf6811a8490da48b811e883311c1\clipboard.png)

### 11.2 AOP在Spring中的作用

横切关注点：跨越应用程序多个模块的方法或功能。既是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。如日志，安全缓存，事务等等。

切面（ASPECT）:横切关注点被模块化的特殊对象。即，它是一个类。

通知（Advice）:切面必须要完成的工作。即，它是类中的一个方法。

目标（Target）：被通知对象。

代理（Proxy）：向目标对象应用通知之后 创建的对象。

切入点（PointCut）：切面通知应用执行的“地点”的定义。

连接点（JoinPoint）：与切入点匹配的执行点。

![img](D:\ProgramData\note_of_youdao\sina1897731780\e1040c77b7ad4226a8206ebcf798bdab\clipboard.png)

### 11.3 使用Spring实现APP

【重点】使用AOP织入，需要导入依赖包

​    <dependency>

​        <groupId>org.aspectj</groupId>

​        <artifactId>aspectjweaver</artifactId>

​        <version>1.9.6</version>

​    </dependency>

方式一：使用Spring的API接口 [主要是API接口实现]

方式二：使用自定义类 [主要是切面aspect实现]

方式三：使用注解实现

**P23 整合 Mybatis**

## 12整合Mybatis

步骤：

1. 导入相关Jar包

junit

mybatis

mysql数据库

spring相关的

aop织入

mybatis-spring [new]

1. 编写配置文件
2. 测试

### 12.1回忆MyBatis

编写实体类

编写核心配置文件

编写接口

编写Mapper.xml

测试

**P24 Mybatis-Spring**

### 12.2 Mybatis-Spring

总结：

1、编写数据源配置

2、sqlSessionFactory

3、sqlSessionTemplate

4、需要给接口加实现类【】

5、将自己写的实现类，注入到Spring中

6、测试

**P25整合Mybatis二**

done

**P26 事务回顾**

## 13 声明式事务

### 1、回顾事务

把一组业务当成一个业务来做；要么都成功，要么都失败

事务在项目开发中，十分的重要，涉及到数据的一致性，不能马虎

确保完整性和一致性；

事务的acid原则

原子性

一致性

隔离性：多个业务可能操作同一个资源，防止数据损坏

持久性：事务一旦提交，结果不被影响

**P27 Spring声明式事务**

### 2、Spring中的事务管理

声明事务：AOP

编程式事务：在代码中进行事务管理

思考：

为什么需要事务？

如果不配置事务，可能存在数据提交不一致

如果不在SPRING配置声明式事务，我们就要手动在代码中配置。

事务在项目的开发中十分重要。

from here

 