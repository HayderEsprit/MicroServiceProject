package com.patien.mspatien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <-- Activer Feign

public class MsPatienApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPatienApplication.class, args);
    }

}
