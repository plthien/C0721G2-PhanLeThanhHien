package com.codegym.shoppingcart.service.impl;

import com.codegym.shoppingcart.model.Order;
import com.codegym.shoppingcart.repository.IOderRepository;
import com.codegym.shoppingcart.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;

    @Override
    public Order save(Order order) {
        return iOderRepository.save(order);
    }
}
