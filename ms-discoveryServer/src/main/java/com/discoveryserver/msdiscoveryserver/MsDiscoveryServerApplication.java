package com.discoveryserver.msdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Activation du serveur

public class MsDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDiscoveryServerApplication.class, args);
    }

}
