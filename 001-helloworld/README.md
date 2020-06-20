# 001-helloword

这是一个使用 `spring-boot-starter-web` 构建的最简单的 Spring Boot Web 项目，启动后访问 `http://localhost:8080/` 显示 `Hello World!`，通过这个工程学习如何快速构建 Spring Boot Web 项目。

## 知识点

首先在 `pom.xml` 中添加依赖 `spring-boot-starter-web`：

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

然后添加两个类：`HelloWorldApp` 为入口类，包含一个 `main` 方法，`HelloWorldController` 为控制器类，用于处理 HTTP 请求。

```
@SpringBootApplication
public class HelloWorldApp {
    public static void main( String[] args ) {
        SpringApplication.run(HelloWorldApp.class, args);
    }
}
```

`HelloWorldApp` 和普通的 Java 入口类有两个主要区别，一个是类上添加了 `@SpringBootApplication` 注解，用于开启 Spring Boot 的自动配置特性以及扫描项目中的 Spring Bean。另一个区别是在 `main` 方法中通过调用 `SpringApplication.run()` 启动 Spring Boot 应用。

```
@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }
}
```

另外，我们在 `HelloWorldController` 类上加上 `@RestController` 注解，用于标识这个类为控制器类，并在 `index()` 方法上加上 `@RequestMapping` 注解，表示这是一条请求映射，将路径为 `/` 的 URL 请求映射到 `index()` 方法。

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
