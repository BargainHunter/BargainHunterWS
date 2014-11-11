package com.bargainhunter.bargainhunterws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ComponentScan
@EnableAutoConfiguration
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
