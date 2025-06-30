package com.rendezvous.rendezvous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka


public class RendezVousApplication {

    public static void main(String[] args) {
        SpringApplication.run(RendezVousApplication.class, args);
    }

}
