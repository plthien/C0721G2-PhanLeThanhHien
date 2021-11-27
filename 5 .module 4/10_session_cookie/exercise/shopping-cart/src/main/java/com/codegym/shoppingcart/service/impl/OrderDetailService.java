package com.codegym.shoppingcart.service.impl;

import com.codegym.shoppingcart.model.OrderDetail;
import com.codegym.shoppingcart.repository.IOrderDetailRepository;
import com.codegym.shoppingcart.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

    @Override
    public void save(OrderDetail orderDetail) {
        iOrderDetailRepository.save(orderDetail);
    }
}
