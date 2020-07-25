# 005-helloworld-configuration

这是一个使用 `spring-boot-starter-web` 构建的最简单的 Spring Boot Web 项目，主要学习 `@Configuration` 和 `@Bean` 注解。

## 知识点

在 Spring 3 之前，都是使用 XML 文件来定义 Bean，像下面这样：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->

</beans>
```

从 Spring 3 开始，我们可以使用 Java 代码来定义 Bean，这被称为 `Java Config`。只要将 `@Configuration` 注解放在某个类上，就可以在这个类中定义一个或多个 Bean。

```
@Configuration
public class TestConfig {
    @Bean
    public TestService testService() {
        return new TestService();
    }
}
```

## Bean 的生命周期

可以使用基于 Java 的配置来管理 Bean 的生命周期，`@Bean` 支持两种属性，即 `initMethod` 和 `destroyMethod`，这些属性可用于定义生命周期方法。在实例化 Bean 或即将销毁它时，容器便可调用生命周期方法。生命周期方法也称为回调方法，因为它将由容器调用。使用 `@Bean` 注释注册的 Bean 也支持 JSR-250 规定的标准 `@PostConstruct` 和 `@PreDestroy` 注解。

## `@Scope` 注解

* singleton：默认值，单例
* prototype：多例（原型作用域）
* request：创建对象，把对象放到 request 域里
* session：创建对象，把对象放到 session 域里
* globalSession：创建对象，把对象放到 globalSession 域里

## 相关引用

### 依赖

* spring-boot-starter-parent
* spring-boot-starter-web
* spring-boot-maven-plugin

### 类

* SpringApplication

### 注解

* SpringBootApplication
* RequestMapping
* RestController

* Configuration [*New*]
* Bean [*New*]
* Scope [*New*]
* PostConstruct [*New*]
* PreDestroy [*New*]
