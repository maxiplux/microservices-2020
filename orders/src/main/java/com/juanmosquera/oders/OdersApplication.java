package com.juanmosquera.oders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class OdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdersApplication.class, args);
    }

}
