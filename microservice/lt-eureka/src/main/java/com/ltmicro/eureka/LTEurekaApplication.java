package com.ltmicro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LTEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LTEurekaApplication.class, args);
    }
}
