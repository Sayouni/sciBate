package com.sci.da;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sci.da.*.*.mapper")
public class SciDaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SciDaApplication.class, args);
    }
}
