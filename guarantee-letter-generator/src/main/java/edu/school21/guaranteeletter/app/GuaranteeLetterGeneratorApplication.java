package edu.school21.guaranteeletter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.guaranteeletter")
public class GuaranteeLetterGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuaranteeLetterGeneratorApplication.class, args);
    }

}
