package com.paranthaman.question1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paranthaman.question1.model.Product;

public interface ProductRepo extends JpaRepository<Product,String> {
    
}