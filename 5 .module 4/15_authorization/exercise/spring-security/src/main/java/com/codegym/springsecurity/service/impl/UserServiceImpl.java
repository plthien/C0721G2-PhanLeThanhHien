package com.codegym.springsecurity.service.impl;

import com.codegym.springsecurity.dto.UserRegistrationDto;
import com.codegym.springsecurity.model.AppUser;
import com.codegym.springsecurity.model.Role;
import com.codegym.springsecurity.repository.IUserRepository;
import com.codegym.springsecurity.service.IRoleService;
import com.codegym.springsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleService iRoleService;

    @Override
    public AppUser saveRegistrationUser(UserRegistrationDto userRegistrationDto) {
        Role role = iRoleService.findByName("ROLE_USER");
        AppUser appUser = new AppUser(userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(), new HashSet<>(Collections.singletonList(role)));
        return iUserRepository.save(appUser);
    }

    @Override
    public AppUser findByEmail(String email) {
        return iUserRepository.findById(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser =iUserRepository.findById(email).orElse(null);

        if (appUser == null){
            System.out.println("User not found! " + email);
            throw new UsernameNotFoundException("User" + email + " was not found in the database.");
        }

        System.out.println("Found user: " + email);
        Set<Role> roles = appUser.getRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if (roles != null){
            for (Role role : roles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        UserDetails userDetails = new User(appUser.getEmail(), appUser.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
