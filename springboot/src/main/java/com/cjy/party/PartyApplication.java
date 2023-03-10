package com.cjy.party;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjy.party.dao")
public class PartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyApplication.class, args);
    }

}
