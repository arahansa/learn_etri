package com.arahansa.springbootlevel1magicuser.domain;

import org.springframework.security.core.GrantedAuthority;

public enum MemberAuthority implements GrantedAuthority {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    String authority;

    MemberAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
