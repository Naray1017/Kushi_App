package com.kushi.in.kushi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories("com.kushi.in.kushi.repository") 
public class KushiApplication {
    public static void main(String[] args) {
        SpringApplication.run(KushiApplication.class, args);
    }
}
