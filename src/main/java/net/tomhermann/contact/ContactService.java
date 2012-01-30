package net.tomhermann.contact;

import net.tomhermann.email.Email;
import net.tomhermann.email.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class ContactService {
	private final EmailService emailService;
	private final Environment environment;

	@Autowired
	public ContactService(EmailService emailService, Environment environment) {
		this.emailService = emailService;
		this.environment = environment;
	}

	public void process(ContactForm message) {
		Email email = new Email()
						.to(environment.getProperty("contact.email"), 
							environment.getProperty("contact.name"))
						.from(message.getEmail(), message.getName())
						.withSubject(message.getSubject())
						.withMessage(message.getMessage());
		emailService.send(email);
	}
}
