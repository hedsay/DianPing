package com.Nreal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.Nreal.mapper")
@SpringBootApplication
public class DianPingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DianPingApplication.class,args);
    }
}
