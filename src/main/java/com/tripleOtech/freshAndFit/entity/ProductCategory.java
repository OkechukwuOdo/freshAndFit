package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;
    private String imageUrl;
    @ManyToMany
//    @OneToMany(mappedBy = "category")
    private List<FoodItem> productList;



    private ProductCategory(String name){
        categoryName=name;
    }
    public static ProductCategory productCategoryInstance(String name){
        return new ProductCategory(name);
    }
}
