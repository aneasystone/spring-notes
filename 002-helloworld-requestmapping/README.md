# 002-helloworld-requestmapping

这是一个使用 `spring-boot-starter-web` 构建的最简单的 Spring Boot Web 项目，主要学习 `RequestMapping` 的用法。

## 知识点

`RequestMapping` 注解可以用于类和方法上，主要作用是将 Web 请求映射到某个 Controller 的某个方法上。

```
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RequestMapping {
}
```

### `@RequestMapping` 基本用法

1. path

```
@RequestMapping(path = "/path-method-all")
```

2. method

```
@RequestMapping(path = "/path-method-post", method = RequestMethod.POST)
```

3. headers

```
@RequestMapping(path = "/path-method-post-headers", method = RequestMethod.POST, headers = "key=value")
```

4. consumes

```
@RequestMapping(path = "/path-method-post-consumes", method = RequestMethod.POST, consumes = "application/json")
```

5. produces

```
@RequestMapping(path = "/path-method-post-produces", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
```

### `@RequestMapping` 高级用法

1. Multiple Path

```
@RequestMapping(path = { "/path-a", "/path-b" }, method = RequestMethod.GET)
```

2. Multiple HTTP Method

```
@RequestMapping(path = "/path-method-multiple", method = { RequestMethod.POST, RequestMethod.PUT })
```

### `@PathVariable` 注解

1. `@PathVariable` 基本用法

```
@RequestMapping(path = "/path-method-get/{id}", method = RequestMethod.GET)
public String pathMethodGet(@PathVariable String id) {
}
```

2. `@PathVariable` 正则表达式

```
@RequestMapping(path = "/path-method-get-regex/{id:[\\d]+}", method = RequestMethod.GET)
public String pathMethodGetRegex(@PathVariable String id) {
}
```

### `@RequestParam` 注解

1. `@RequestParam` 基本用法

```
@RequestMapping(path = "/path-method-get-param", method = RequestMethod.GET)
public String pathMethodGetParam(@RequestParam String id) {
}
```

2. `@RequestParam` 默认值

```
@RequestMapping(path = "/path-method-get-param-default", method = RequestMethod.GET)
public String pathMethodGetParamDefault(@RequestParam(defaultValue = "1") String id) {
}
```

3. `@RequestParam` 可选参数

```
@RequestMapping(path = "/path-method-get-param-required", method = RequestMethod.GET)
public String pathMethodGetParamRequired(@RequestParam String a, @RequestParam(required = false) String b) {
}
```

### `@RequestMapping` 简写

* @GetMapping
* @PostMapping
* @PutMapping
* @DeleteMapping
* @PatchMapping

```
@GetMapping(path = "/path-method-get-simple")
public String pathMethodGetSimple() {
}
```

## 参考

1. [Spring @RequestMapping | Baeldung](https://www.baeldung.com/spring-requestmapping)
