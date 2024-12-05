package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
