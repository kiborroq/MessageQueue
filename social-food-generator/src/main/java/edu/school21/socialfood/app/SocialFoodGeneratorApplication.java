package edu.school21.socialfood.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.socialfood")
public class SocialFoodGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialFoodGeneratorApplication.class, args);
	}

}
