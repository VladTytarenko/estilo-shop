package com.tytarenko.estiloshop.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Admin implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long adminId;

	@NotNull
	@Size(min = 4, max = 40)
	private String name;

	@NotNull
	//@Email
	private String email;

	@NotNull
	@Size(min = 6)
	private String password;

	public Admin() {
	}

	public Admin(@NotNull long adminId, @NotNull String name, @NotNull String email, @NotNull String password) {
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<UserType> ga = new ArrayList<>();
		ga.add(UserType.ADMIN);
		return ga;
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
}
