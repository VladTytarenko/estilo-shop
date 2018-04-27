package com.tytarenko.estiloshop.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Order {
	
	@NotNull
	@NotEmpty
	private String first;

	@NotNull
	@NotEmpty
	private String second;

	@NotNull
	@NotEmpty
	private String last;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String phone;

	@NotNull
	@NotEmpty
	private String country;

	@NotNull
	@NotEmpty
	private String city;

	@NotNull
	@NotEmpty
	private String zip;

	@NotNull
	@NotEmpty
	private String address;
	
	public Order() {
		
	}

	public Order(String first, String second, String last, String email, String phone, String country, String city,
			String zip, String address) {
		super();
		this.first = first;
		this.second = second;
		this.last = last;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.zip = zip;
		this.address = address;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [first=");
		builder.append(first);
		builder.append(", second=");
		builder.append(second);
		builder.append(", last=");
		builder.append(last);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", country=");
		builder.append(country);
		builder.append(", city=");
		builder.append(city);
		builder.append(", zip=");
		builder.append(zip);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
