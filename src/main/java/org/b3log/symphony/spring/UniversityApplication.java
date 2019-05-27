package org.b3log.symphony.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }


    public static void startSpringBoot(String[] args){SpringApplication.run(UniversityApplication.class, args);}
}
