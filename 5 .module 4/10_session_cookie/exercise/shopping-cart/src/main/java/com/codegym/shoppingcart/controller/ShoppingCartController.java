package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.*;
import com.codegym.shoppingcart.service.ICustomerService;
import com.codegym.shoppingcart.service.IOderService;
import com.codegym.shoppingcart.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    @Autowired
    private IOderService iOderService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/payment")
    public ModelAndView payment(@SessionAttribute("cart") Cart cart, @ModelAttribute("customer") Customer customer){
        Order order = new Order();
        order = iOderService.save(order);

        List<OrderDetail> orderDetails = new ArrayList<>();
        Map<Product,Integer> products = cart.getProducts();

        OrderDetail orderDetail = null;
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            orderDetail = new OrderDetail();
            orderDetail.setProduct(entry.getKey());
            orderDetail.setQuantity(entry.getValue());
            orderDetail.setOrder(order);
            iOrderDetailService.save(orderDetail);

            total+= entry.getValue() * entry.getKey().getPrice();
            orderDetails.add(orderDetail);
        }

        order.setCustomer(iCustomerService.save(customer));
        order.setOrderDetails(orderDetails);
        order.setTotal(total);

        iOderService.save(order);
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message","You ordered successfully!");
        return modelAndView;

    }

}
