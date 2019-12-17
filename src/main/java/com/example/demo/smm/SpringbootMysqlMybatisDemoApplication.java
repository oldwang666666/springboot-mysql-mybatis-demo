package com.example.demo.smm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@MapperScan("com.example.demo.smm.mapper")
@SpringBootApplication
@EnableRetry
public class SpringbootMysqlMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlMybatisDemoApplication.class, args);
    }

}
