package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
