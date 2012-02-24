package net.tomhermann.contact;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class ContactForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Please provide your name.")
	private String name;

	@Email(message = "Please provide a valid email address.")
	@NotBlank(message = "Please provide your email address.")
	private String email;

	@NotBlank(message = "Please provide a subject for your message.")
	@Size(message = "The subject cannot exceed 150 characters", max = 150)
	private String subject;

	@NotBlank(message = "Please provide a message.")
	private String message;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("Email", email)
				.append("Message", message)
				.append("Name", name)
				.append("Subject", subject)
			.toString();
	}
}
