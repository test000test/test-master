package com.example.registrationform.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    RoleEnum() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
