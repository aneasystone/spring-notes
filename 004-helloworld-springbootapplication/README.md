# 004-helloworld-springbootapplication

这是一个使用 `spring-boot-starter-web` 构建的最简单的 Spring Boot Web 项目，主要学习 `@SpringBootApplication` 注解的原理。

## 知识点

`@SpringBootApplication` 注解的定义如下：

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
}
```

其中 `@Target` 用于说明这个注解出现的位置，`ElementType.TYPE` 表示只能作用于类上，类似的，如果是 `ElementType.METHOD` 表示注解作用于方法上，如果是  `ElementType.FIELD` 表示注解作用于域上。

`@Retention` 用于说明注解的生命周期，注解有三个生命周期：`RetentionPolicy.SOURCE` 表示注解只保留在源文件，当 Java 文件编译成 class 文件时，注解被遗弃；`RetentionPolicy.CLASS` 表示注解保留到 class 文件，当 JVM 加载 class 时注解被遗弃；`RetentionPolicy.RUNTIME` 表示注解在 JVM 加载 class 之后仍然保留，被称为运行时注解。这里的 `@SpringBootApplication` 就是运行时注解。

`@Documented` 表示这个注解的信息会被包括在 javadoc 生成的文档中。

`@Inherited` 表示这个注解是否被子类继承，子类会继承父类使用的注解中被 `@Inherited` 修饰的注解。

上面这四个注解都是在自定义注解时非常常用的，但是要实现 `@SpringBootApplication` 注解的功能，最关键的还是下面这三个注解：

* `@SpringBootConfiguration`
* `@EnableAutoConfiguration`
* `@ComponentScan`

其中 `@SpringBootConfiguration` 注解的定义如下：

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
}
```

可以看到 `@SpringBootConfiguration` 实际上就是一个 `@Configuration` 注解，用于定义配置类，可替换 xml 配置文件，被注解的类内部包含有一个或多个被 `@Bean` 注解的方法，这些方法将会被 `AnnotationConfigApplicationContext` 或 `AnnotationConfigWebApplicationContext` 类进行扫描，并用于构建 Bean 定义，初始化 Spring 容器。在我们这个例子中，`SpringBootApp` 类里并没有定义 Bean，所以这个注解可以忽略。

`@EnableAutoConfiguration` 注解的定义如下：

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
}
```

其中 `@AutoConfigurationPackage` 的定义如下：

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
```

可以看出 `@EnableAutoConfiguration` 注解实际上是由两个 `@Import` 注解组成的。`@Import` 可以将某个类注入 Spring 容器中，一般来说有四种用法：

1. 注入带 `@Configuration` 的配置类
1. 注入普通类（4.2 之后的版本支持）
2. `ImportSelector`
3. `ImportBeanDefinitionRegistrar`

通过查看 `AutoConfigurationImportSelector` 和 `Registrar` 的源码，可以看出它们分别对应 `ImportSelector` 和 `ImportBeanDefinitionRegistrar` 两种方式。

```
public class AutoConfigurationImportSelector implements DeferredImportSelector, BeanClassLoaderAware, ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered {
}
```

```
static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports {
}
```

最后一个 `@ComponentScan` 注解，它告诉 Spring 从哪里去找带 `@Component` 的类（包括 `@Controller`，`@Service`，`@Repository` 等），然后将其注入到 Spring 容器中，它有下面几种用法：

* 自定扫描路径下边带有 `@Controller`，`@Service`，`@Repository`，`@Component` 注解加入 Spring 容器
* 通过 `includeFilters` 加入扫描路径下没有以上注解的类加入 Spring 容器
* 通过 `excludeFilters` 过滤出不用加入 Spring 容器的类

通过上面的分析，我们可以改动下 `001-helloworld` 项目，将 `SpringBootApp` 上面的 `@SpringBootApplication` 注解改成 `@EnableAutoConfiguration` 和 `@ComponentScan`，程序一样可以跑起来。

```
@EnableAutoConfiguration
@ComponentScan
public class SpringBootApp {
}
```

## 相关引用

### 依赖

* spring-boot-starter-parent
* spring-boot-starter-web
* spring-boot-maven-plugin

### 类

* SpringApplication

* AutoConfigurationImportSelector [*New*]
* Registrar [*New*]

### 注解

* SpringBootApplication
* RequestMapping
* RestController

* Target [*New*]
* Retention [*New*]
* Documented [*New*]
* Inherited [*New*]
* SpringBootConfiguration [*New*]
* @Configuration [*New*]
* EnableAutoConfiguration [*New*]
* AutoConfigurationPackage [*New*]
* Import [*New*]
* ComponentScan [*New*]
