package net.tomhermann.config;

import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;

import net.tomhermann.email.EmailService;
import net.tomhermann.email.VelocityEmailService;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@Configuration
public class MailConfig {
	@Inject
	private Environment environment;

	@Bean
	public VelocityEngine velocityEngine() throws IOException {
		VelocityEngineFactoryBean velocityEngineFactory = new VelocityEngineFactoryBean();
		Properties properties = new Properties();
		properties.put("resource.loader", "class");
		properties.put("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngineFactory.setVelocityProperties(properties);
		return velocityEngineFactory.createVelocityEngine();
	}

	@Bean
	public EmailService emailService() throws IOException {
		return new VelocityEmailService(mailSender(), velocityEngine());
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
