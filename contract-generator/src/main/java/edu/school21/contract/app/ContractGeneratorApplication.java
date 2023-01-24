package edu.school21.contract.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.contract")
public class ContractGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractGeneratorApplication.class, args);
    }

}
