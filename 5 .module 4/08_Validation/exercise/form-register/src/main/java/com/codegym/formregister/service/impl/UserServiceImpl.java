package com.codegym.formregister.service.impl;

import com.codegym.formregister.model.User;
import com.codegym.formregister.repository.IUserRepository;
import com.codegym.formregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
