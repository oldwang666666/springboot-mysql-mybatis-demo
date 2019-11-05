package com.example.demo.smm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.smm.mapper")
@SpringBootApplication
public class SpringbootMysqlMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlMybatisDemoApplication.class, args);
    }

}
