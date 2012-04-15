package net.tomhermann.config;

import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.zombietank.email.EmailService;
import com.zombietank.email.support.SimpleEmailService;

/*** This configuration class is responsible for configuring cross-cutting concerns in the application. */
@Configuration
@ComponentScan(basePackages = "net.tomhermann", excludeFilters = { @Filter(Configuration.class) })
@ImportResource("classpath:spring/*-context.xml")
@PropertySource("config/application.properties")
public class ApplicationConfig {
	@Inject
	private Environment environment;
	
	@Bean
	public EmailService emailService() throws IOException {
		return new SimpleEmailService(mailSender());
	}

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding(environment.getProperty("mail.encoding", "UTF-8"));
		mailSender.setHost(environment.getProperty("mail.host", "localhost"));
		mailSender.setPort(environment.getProperty("mail.port", Integer.class, 25));
		mailSender.setUsername(environment.getProperty("mail.username")); 
		mailSender.setPassword(environment.getProperty("mail.password"));
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth", Boolean.class, false));
		properties.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable", Boolean.class, false));
		mailSender.setJavaMailProperties(properties);
		return mailSender;
	}
}
