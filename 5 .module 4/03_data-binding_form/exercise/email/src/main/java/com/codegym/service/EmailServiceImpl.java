package com.codegym.service;

import com.codegym.model.Email;


public class EmailServiceImpl implements IEmailService {
    private static Email email;

    static {
        email = new Email("Japanese", 50, true, "Thor King, Asgard");
    }

    @Override
    public Email findAll() {
        return email;
    }

    @Override
    public void update(Email emailNew) {
        email.setLanguage(emailNew.getLanguage());
        email.setPageSize(emailNew.getPageSize());
        email.setSpamsFilter(emailNew.isSpamsFilter());
        email.setSignature(emailNew.getSignature());

    }
}
