package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Long, Product> {
}
