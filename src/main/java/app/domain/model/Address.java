package app.domain.model;

import javax.persistence.Entity;

import app.domain.persistence.DefaultEntity;

@Entity
public final class Address extends DefaultEntity {

	public Address() {
	}

	public Address(String line1, String line2, String city, String state,
			String zipCode) {

		setLine1(line1);
		setLine2(line2);
		setCity(city);
		setState(state);
		setPostalCode(zipCode);
	}

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String postalCode;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String zipCode) {
		this.postalCode = zipCode;
	}
}
