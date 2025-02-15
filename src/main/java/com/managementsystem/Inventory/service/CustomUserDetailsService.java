package com.managementsystem.Inventory.service;

import com.managementsystem.Inventory.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override// Handles null access of details 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        com.managementsystem.Inventory.model.User user =userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );


    }


}
