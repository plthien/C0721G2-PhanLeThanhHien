package com.codegym.springsecurity.service;

import com.codegym.springsecurity.model.Role;

public interface IRoleService {
    Role findByName(String name);
}
