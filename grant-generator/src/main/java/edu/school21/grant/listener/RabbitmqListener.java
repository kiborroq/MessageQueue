package edu.school21.grant.listener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.common.freemarker.FreemarkerTemplateRender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Slf4j
@Service
public class RabbitmqListener {

	private final DateTimeFormatter formatter;
	private final FreemarkerTemplateRender freemarkerTemplateRender;
	private final ObjectMapper objectMapper;
	private final Path basePath;

	public RabbitmqListener(@Value("${edu.school21.documents.generate.directory}") String documentDirectoryPath) {
		this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.freemarkerTemplateRender = new FreemarkerTemplateRender("/templates");
		this.objectMapper = new ObjectMapper();
		this.basePath = Paths.get(documentDirectoryPath);
	}

	@RabbitListener(queues = "${edu.school21.amq.queue.food}")
	public void onStudentInfoReceive(Message message) {
		try {
			StudentInfo studentInfo = objectMapper.readValue(message.getBody(), StudentInfo.class);

			String filename = String.format("%s-%s_%d-course_%s_grant.pdf",
					studentInfo.getFirstName().toLowerCase(),
					studentInfo.getLastName().toLowerCase(),
					studentInfo.getCourse(),
					LocalDate.now().format(formatter));

			Path path = basePath.resolve(filename);
			try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
				freemarkerTemplateRender.renderPdf("grant-doc.ftl", Collections.singletonMap("student", studentInfo), fos);
				fos.flush();
			}

			log.info("Document rendered for student: {}", studentInfo);
		} catch (Exception e) {
			log.error("Error during document render", e);
		}
	}

	@lombok.Value
	public static class StudentInfo {

		/** Last name */
		String lastName;
		/** First name */
		String firstName;
		/** Phone number */
		String phone;
		/** Age */
		Integer age;
		/** Course number */
		Integer course;
		/** Residence place */
		String residencePlace;

		@JsonCreator
		public StudentInfo(@JsonProperty("lastName") String lastName,
						   @JsonProperty("firstName") String firstName,
						   @JsonProperty("phone") String phone,
						   @JsonProperty("age") Integer age,
						   @JsonProperty("course") Integer course,
						   @JsonProperty("residencePlace") String residencePlace) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.phone = phone;
			this.age = age;
			this.course = course;
			this.residencePlace = residencePlace;
		}
	}

}
