package edu.school21.studentsdataproducer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
		return template;
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		// Create queues and exchanges when app is starting
		return args -> connectionFactory.createConnection().close();
	}

	/**
	 * Workflow of 'social assistance' config<p>
	 *
	 * {@link #socialAssistanceExchange} (fanout) -> {@link #socialFoodQueue}, {@link #financialAssistanceQueue}, {@link #transportationCostsQueue}
	 */
	@Configuration
	public static class SocialAssistanceConfig {

		@Value("${edu.school21.amq.queue.social-food}")
		private String socialFoodQueue;
		@Value("${edu.school21.amq.queue.financial-assistance}")
		private String financialAssistanceQueue;
		@Value("${edu.school21.amq.queue.transportation-costs}")
		private String transportationCostsQueue;
		@Value("${edu.school21.amq.exchange.social-assistance}")
		private String socialAssistanceExchange;

		@Bean
		public Queue socialFoodQueue() {
			return new Queue(socialFoodQueue);
		}

		@Bean
		public Queue financialAssistanceQueue() {
			return new Queue(financialAssistanceQueue);
		}

		@Bean
		public Queue transportationCostsQueue() {
			return new Queue(transportationCostsQueue);
		}

		@Bean
		public FanoutExchange socialAssistanceExchange() {
			return new FanoutExchange(socialAssistanceExchange);
		}

		@Bean
		public Binding socialFoodBinding() {
			return BindingBuilder.bind(socialFoodQueue()).to(socialAssistanceExchange());
		}

		@Bean
		public Binding financialAssistanceBinding() {
			return BindingBuilder.bind(financialAssistanceQueue()).to(socialAssistanceExchange());
		}

		@Bean
		public Binding transportationCostsBinding() {
			return BindingBuilder.bind(transportationCostsQueue()).to(socialAssistanceExchange());
		}

	}

	/**
	 * Workflow of 'grant' config<p>
	 *
	 * {@link #grantExchange} (topic)<p>
	 * |<p>
	 * -- grant.#   -> {@link #grantOtherExchange} (fanout) -> {@link #consentQueue}, {@link #guaranteeLetterQueue}, {@link #grantQueue}<p>
	 * |<p>
	 * -- grant.1.* -> {@link #contractQueue}<p>
	 */
	@Configuration
	public static class GrantConfig {

		@Value("${edu.school21.amq.queue.consent}")
		private String consentQueue;
		@Value("${edu.school21.amq.queue.guarantee-letter}")
		private String guaranteeLetterQueue;
		@Value("${edu.school21.amq.queue.grant}")
		private String grantQueue;
		@Value("${edu.school21.amq.queue.contract}")
		private String contractQueue;
		@Value("${edu.school21.amq.exchange.grant}")
		private String grantExchange;
		@Value("${edu.school21.amq.exchange.grant.other}")
		private String grantOtherExchange;

		@Bean
		public Queue consentQueue() {
			return new Queue(consentQueue);
		}

		@Bean
		public Queue guaranteeLetterQueue() {
			return new Queue(guaranteeLetterQueue);
		}

		@Bean
		public Queue grantQueue() {
			return new Queue(grantQueue);
		}

		@Bean
		public Queue contractQueue() {
			return new Queue(contractQueue);
		}

		@Bean
		public TopicExchange grantExchange() {
			return new TopicExchange(grantExchange);
		}

		@Bean
		public FanoutExchange grantOtherExchange() {
			return new FanoutExchange(grantOtherExchange);
		}

		@Bean
		public Binding contractBinding() {
			return BindingBuilder.bind(contractQueue()).to(grantExchange()).with("grant.1.*");
		}

		@Bean
		public Binding consentBinding() {
			return BindingBuilder.bind(consentQueue()).to(grantOtherExchange());
		}

		@Bean
		public Binding guaranteeLetterBinding() {
			return BindingBuilder.bind(guaranteeLetterQueue()).to(grantOtherExchange());
		}

		@Bean
		public Binding grantBinding() {
			return BindingBuilder.bind(grantQueue()).to(grantOtherExchange());
		}

		@Bean
		public Binding grantExchangeToOtherGrantExchangeBinding() {
			return BindingBuilder.bind(grantOtherExchange()).to(grantExchange()).with("grant.#");
		}

	}

}
