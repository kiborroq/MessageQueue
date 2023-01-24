package edu.school21.grant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.grant")
public class GrantGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrantGeneratorApplication.class, args);
    }

}
