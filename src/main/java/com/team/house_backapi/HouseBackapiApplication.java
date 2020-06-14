package com.team.house_backapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.team.house_backapi.dao")
@SpringBootApplication
@ServletComponentScan("com.team.house_backapi.filter")
public class HouseBackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseBackapiApplication.class, args);
    }

}
