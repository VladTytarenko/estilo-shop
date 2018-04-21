package com.tytarenko.estiloshop.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Customer implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long customerId;

	@NotNull
	@Size(min = 4, max = 40)
	private String name;

	@NotNull
	@Size(max = 25)
	private String mobilePhone;

	//Email
	@NotNull
	private String customerEmail;

	@Size(min = 6)
	private String password;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Purchase> purchaseList;

	public Customer() {
	}

	public Customer(@NotNull String name, @NotNull String customerEmail,
					@NotNull String mobilePhone) {
		this.name = name;
		this.customerEmail = customerEmail;
		this.mobilePhone = mobilePhone;
	}

	public Customer(@NotNull String name, @NotNull String mobilePhone,
					@NotNull String customerEmail, @NotNull String password) {
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.customerEmail = customerEmail;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> ga = new ArrayList<>();
		ga.add(UserType.CUSTOMER);
		return ga;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return customerEmail;
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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setUsername(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", name='" + name + '\'' +
				", mobilePhone='" + mobilePhone + '\'' +
				", customerEmail='" + customerEmail + '\'' +
				", password='" + password + '\'' +
				", purchaseList=" + purchaseList +
				'}';
	}
}