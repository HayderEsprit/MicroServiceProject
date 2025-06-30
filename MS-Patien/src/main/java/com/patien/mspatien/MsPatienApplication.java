package com.patien.mspatien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients // <-- Activer Feign
@EnableKafka



public class MsPatienApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPatienApplication.class, args);
    }

}
