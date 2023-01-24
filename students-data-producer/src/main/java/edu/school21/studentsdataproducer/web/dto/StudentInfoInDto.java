package edu.school21.studentsdataproducer.web.dto;

import lombok.Value;

@Value
public class StudentInfoInDto {

	/** Last name */
	String lastName;
	/** First name */
	String firstName;
	/** Age */
	Integer age;
	/** Phone number */
	String phone;
	/** Course number */
	Integer course;
	/** Residence place */
	String residencePlace;

}
