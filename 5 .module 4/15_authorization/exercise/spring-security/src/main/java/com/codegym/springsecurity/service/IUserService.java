package com.codegym.springsecurity.service;

import com.codegym.springsecurity.dto.UserRegistrationDto;
import com.codegym.springsecurity.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    AppUser saveRegistrationUser(UserRegistrationDto userRegistrationDto);
    AppUser findByEmail(String email);
}
