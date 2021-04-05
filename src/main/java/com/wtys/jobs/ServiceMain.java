package com.wtys.jobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServiceMain {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServiceMain.class, args);
    }

}