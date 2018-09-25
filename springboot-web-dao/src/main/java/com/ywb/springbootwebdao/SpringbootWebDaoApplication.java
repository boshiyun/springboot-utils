package com.ywb.springbootwebdao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.ywb.springbootwebdao.io.dao")
public class SpringbootWebDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebDaoApplication.class, args);
    }
}
