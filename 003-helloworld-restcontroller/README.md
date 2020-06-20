# 003-helloworld-restcontroller

这是一个使用 `spring-boot-starter-web` 构建的最简单的 Spring Boot Web 项目，主要学习 `@RestController` 的用法以及 `@RestController` 和 `@Controller` 的区别。

## 知识点

`@RestController` 注解是 `@Controller` 和 `@ResponseBody` 两个注解的结合。在 Spring 4.0 中被引入，用于更方便的创建 Restful 接口，省去了在每个方法上加 `@ResponseBody` 的麻烦。

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
}
```

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

* Controller [*New*]
* ResponseBody [*New*]

## 参考

1. [The Spring @Controller and @RestController Annotations](https://www.baeldung.com/spring-controller-vs-restcontroller)
