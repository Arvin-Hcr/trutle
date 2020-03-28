package com.hcr.turtle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hcr.turtle.mapper")
public class TurtleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurtleApplication.class, args);
    }

}
