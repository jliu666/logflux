# logflux

logflux是一个日志框架的lambda表达式包装，用于延迟日志字符串的生成时间

### 传统日志
```java
log.info("INFO a {} b {}",JsonUtil.ObjectToJson(instance),"success");
```
如果日志级别为error，则info日志不需要打印，而`JsonUtil.ObjectToJson(instance)`此时已经执行，浪费cpu资源，降低程序性能

### logflux日志
```java
    log.info(
        "format {} {} {} {} {}",
        () -> 1,
        () -> 2,
        () -> 3,
        () -> {
          int a = 1 + 1;
          int b = 1 + 2;
          return a + b;
        },
        () -> JsonUtil.ObjectToJson(instance));
```
依据Java 8 及以上的lambda表达式特性，将日志参数以lambda表达式的方式传入，等到日志确认级别需要打印后再调用相关的消耗资源的方式，能够大量节省日志对CPU和内存的消耗


### logflux使用

首先导入logflux的jar包，logflux目前已经对slf4j进行了支持，仅需将原先导入的slf4j的包修改为logflux的包即可

`org.slf4j.Logger -> org.github.logflux.slf4j.Logger`


`org.slf4j.LoggerFactory -> org.github.logflux.slf4j.LoggerFactory`

