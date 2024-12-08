//package com.example.doctorAppointment.config;
//
//import com.example.doctorAppointment.model.coreUser.CoreUser;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.security.Principal;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//public class UserPrinciple implements UserDetails {
//
//    public CoreUser coreUser;
//    public UserPrinciple(CoreUser coreUser) {
//        this.coreUser=coreUser;
//    }
//        @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton( new SimpleGrantedAuthority("USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return coreUser.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return coreUser.getUserName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
