package edu.school21.consent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.consent")
public class ConsentGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsentGeneratorApplication.class, args);
	}

}
