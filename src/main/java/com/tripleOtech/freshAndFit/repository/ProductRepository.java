package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
