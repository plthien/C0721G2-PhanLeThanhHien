package com.codegym.springsecurity.service.impl;

import com.codegym.springsecurity.dto.UserRegistrationDto;
import com.codegym.springsecurity.model.AppUser;
import com.codegym.springsecurity.model.Role;
import com.codegym.springsecurity.repository.IUserRepository;
import com.codegym.springsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    @Transactional
    public AppUser saveRegistrationUser(UserRegistrationDto userRegistrationDto) {
        Role role = new Role("ROLE_USER");
        AppUser appUser = new AppUser(userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(), new HashSet<>(Collections.singletonList(role)));
        return iUserRepository.save(appUser);
    }

    @Override
    public AppUser findByEmail(String email) {
        return iUserRepository.findById(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
