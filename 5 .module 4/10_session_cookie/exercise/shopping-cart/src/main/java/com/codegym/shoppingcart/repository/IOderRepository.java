package com.codegym.shoppingcart.repository;

import com.codegym.shoppingcart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Order,Long> {
}
