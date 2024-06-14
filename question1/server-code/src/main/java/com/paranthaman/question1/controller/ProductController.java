package com.paranthaman.question1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paranthaman.question1.model.Product;
import com.paranthaman.question1.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String getMethodName() {
        return new String("ProductController");
    }
    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/categories/{categoryName}/products/{pid}")
    public Product getProduct(@PathVariable String pid) {
        return productService.getProduct(pid);
    }

    // Question 1 get top N product
    @GetMapping("/companies/{companyName}/categories/{categoryName}/products")
    public List<Product> getTopTenProducts(@PathVariable String companyName, @PathVariable String categoryName,
            @RequestParam int top, @RequestParam int minPrice, @RequestParam int maxPrice) {
        return productService.getTopTenProducts(companyName, categoryName,top,minPrice,maxPrice);
    }

    @PostMapping("/products")
    public List<Product> postMethodName(@RequestBody List<Product> product) {
        return productService.addProduct(product);
    }
    

}
