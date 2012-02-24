package net.tomhermann.email.support;

public class AddressException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AddressException(String address, Throwable cause) {
		super("Invalid address: " + address, cause);
	}
}
