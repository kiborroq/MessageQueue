package edu.school21.studentsdataproducer.web.controller;

import edu.school21.studentsdataproducer.web.dto.StudentInfoInDto;
import edu.school21.studentsdataproducer.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/send/data")
	public String sendInfo(StudentInfoInDto dto) {
		studentService.sendInfo(dto);
		return "redirect:/";
	}

}
