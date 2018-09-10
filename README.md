# Gson Object Mapper for Open Unirest
[![Build Status](https://travis-ci.org/OpenUnirest/unirest-java.svg?branch=master)](https://travis-ci.org/OpenUnirest/unirest-java)

Welcome. This is a Object Mapper for Open Unirest based on the popular google Gson JSON parser.
Use it like this:

```java
     Options.setObjectMapper(new GsonObjectMapper());
```

You may also provide it with your own Gson instance.

## Install With [Maven](https://mvnrepository.com/artifact/io.github.openunirest/)
```
<dependency>
    <groupId>io.github.openunirest</groupId>
        <artifactId>object-mappers-gson</artifactId>
        <version>1.0.00</version>
</dependency>
```