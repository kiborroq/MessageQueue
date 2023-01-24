package edu.school21.financialassistance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.financialassistance")
public class FinancialAssistanceGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialAssistanceGeneratorApplication.class, args);
	}

}
