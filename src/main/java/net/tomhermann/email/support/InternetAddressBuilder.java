package net.tomhermann.email.support;

import javax.mail.internet.InternetAddress;

public final class InternetAddressBuilder {

	public static InternetAddress newAddress(final String address) {
		try {
			return new InternetAddress(address);
		} catch (Exception e) {
			throw new AddressException(address, e);
		}
	}

	public static InternetAddress newAddress(final String address, final String personal) {
		try {
			return new InternetAddress(address, personal);
		} catch (Exception e) {
			throw new AddressException(address, e);
		}
	}
	
	private InternetAddressBuilder() {
	}
}
