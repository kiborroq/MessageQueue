package edu.school21.studentsdataproducer.web.service;

import edu.school21.studentsdataproducer.web.dto.StudentInfoInDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${edu.school21.amq.exchange.social-assistance}")
	private String socialAssistanceExchange;
	@Value("${edu.school21.amq.exchange.grant}")
	private String grantExchange;

	public void sendInfo(StudentInfoInDto dto) {
		amqpTemplate.convertAndSend(socialAssistanceExchange, null, dto);
		amqpTemplate.convertAndSend(grantExchange, String.format("grant.%d.documents", dto.getCourse()), dto);
	}

}
