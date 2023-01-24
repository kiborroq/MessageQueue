package edu.school21.studentsdataproducer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.school21.studentsdataproducer")
public class StudentsDataProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsDataProducerApplication.class, args);
	}

}
