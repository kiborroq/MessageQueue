package edu.school21.transportationcosts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.transportationcosts")
public class TransportationCostsGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportationCostsGeneratorApplication.class, args);
	}

}
