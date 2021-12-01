package com.codegym.blogmanagement.service.impl;

import com.codegym.blogmanagement.model.Role;
import com.codegym.blogmanagement.model.User;
import com.codegym.blogmanagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User" + username + " was not found in the database.");
        }

        System.out.println("Found user: " + username);
        List<Role> roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (roles != null) {
            for (Role role : roles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        UserDetails userDetails =
                (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
