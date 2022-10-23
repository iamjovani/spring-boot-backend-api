package com.springboot.springboot.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.springboot.domain.AppUser;

public class AppUserDetails implements UserDetails{


    public String UserName;
    public String Password;
    private boolean Enabled;
    private List<GrantedAuthority> authority;

    public AppUserDetails(){
        this.UserName = null;
    }

    public AppUserDetails(AppUser user){
        this.UserName = user.getUserName();
        this.Password = user.getPassword();
        this.Enabled  = user.getEnabled();
        this.authority = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return UserName;
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
        return Enabled;
    }


    
}
