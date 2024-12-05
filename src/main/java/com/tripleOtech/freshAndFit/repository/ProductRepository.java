package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.SampleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<SampleProduct,Long> {
}
