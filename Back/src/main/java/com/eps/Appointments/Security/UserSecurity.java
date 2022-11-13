package com.eps.Appointments.Security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eps.Appointments.persistance.entities.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserSecurity implements UserDetails {

   private User user;
   private String role;

   public void setAuthority(String role) {
      this.role = role;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return Arrays.asList(new SimpleGrantedAuthority(this.role));
   }

   @Override
   public String getPassword() {
      return user.getPassword();
   }

   @Override
   public String getUsername() {
      return user.getId();
   }

   @Override
   public boolean isAccountNonExpired() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isAccountNonLocked() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isEnabled() {
      // TODO Auto-generated method stub
      return false;
   }

}
