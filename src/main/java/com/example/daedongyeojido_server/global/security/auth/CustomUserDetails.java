package com.example.daedongyeojido_server.global.security.auth;

import com.example.daedongyeojido_server.domain.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public record CustomUserDetails(User user) implements UserDetails {

    @Override
    public String getUsername() {
        return user.getClassNumber();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.getPart().toString())));
    }

    @Override
    public String getPassword() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

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