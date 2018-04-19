package com.tytarenko.estiloshop.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Admin implements UserDetails {

	@NotNull
	@Id
	@GeneratedValue
	private long adminId;

	@NotNull
	@Size(min = 4, max = 40)
	private String name;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 6)
	private String password;

	public Admin(@NotNull long adminId, @NotNull String name, @NotNull String email, @NotNull String password) {
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
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
}
