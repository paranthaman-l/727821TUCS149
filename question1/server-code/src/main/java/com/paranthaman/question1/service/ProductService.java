package com.paranthaman.question1.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paranthaman.question1.model.Product;
import com.paranthaman.question1.repo.ProductRepo;

import lombok.AllArgsConstructor;

/**
 * ProductService
 */
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product getProduct(String pid) {
        return productRepo.findById(pid).orElse(null);
    }

    public List<Product> getTopTenProducts(String companyName, String categoryName, int top, int minPrice,
            int maxPrice) {
        List<Product> list = productRepo.findAll();
        list.stream().filter(x -> x.getProductName().contains(categoryName));
        Collections.sort(list, (x, y) -> Double.compare(y.getRating() , x.getRating()));
        return list.subList(0, top);
    }

    public List<Product> addProduct(List<Product> product) {
        return productRepo.saveAll(product);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

}