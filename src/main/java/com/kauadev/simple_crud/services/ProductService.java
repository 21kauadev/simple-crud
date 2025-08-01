package com.kauadev.simple_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauadev.simple_crud.domain.product.Product;
import com.kauadev.simple_crud.domain.product.exceptions.ProductNotFoundException;
import com.kauadev.simple_crud.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
