package com.baran.simplebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.baran")
public class SimpleBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingApplication.class, args);
    }

}
