package com.tytarenko.estiloshop.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {

    ADMIN,
    CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
