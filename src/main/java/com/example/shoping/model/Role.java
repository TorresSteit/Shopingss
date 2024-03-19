package com.example.shoping.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }

    @Override
    public String getAuthority() {
        return null;
    }
}

