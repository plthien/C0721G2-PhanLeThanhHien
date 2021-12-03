package com.codegym.springsecurity.service.impl;

import com.codegym.springsecurity.model.Role;
import com.codegym.springsecurity.repository.IRoleRepository;
import com.codegym.springsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Role findByName(String name) {
        return iRoleRepository.findByNameEquals(name);
    }
}
