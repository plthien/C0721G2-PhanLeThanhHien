package com.codegym.service;

import com.codegym.model.Email;

import java.util.List;

public interface IEmailService {

    public Email findAll();
    public void update(Email email);

}
