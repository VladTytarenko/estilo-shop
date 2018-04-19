package com.tytarenko.estiloshop.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Customer implements UserDetails {

	@NotNull
	@Id
	@GeneratedValue
	private long customerId;

	@NotNull
	@Size(min = 4, max = 40)
	private String name;

	@NotNull
	@Size(max = 100)
	private String addreess;

	@NotNull
	@Size(max = 25)
	private String mobilePhone;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 6)
	private String password;

	public Customer(String name, String mobilePhone, String address) {
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.addreess = address;
	}

	public Customer(@NotNull long customerId, @NotNull String name, @NotNull String mobilePhone,
				 @NotNull String address, @NotNull String email, @NotNull String password) {
		this.customerId = customerId;
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.addreess = address;
		this.email = email;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddreess() {
		return addreess;
	}

	public void setAddreess(String addreess) {
		this.addreess = addreess;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}