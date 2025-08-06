package com.kauadev.simple_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauadev.simple_crud.domain.product.Product;
import com.kauadev.simple_crud.domain.product.ProductDTO;
import com.kauadev.simple_crud.domain.product.exceptions.ProductMissingFieldsException;
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

    public Product createProduct(ProductDTO data) {
        Product product = new Product();

        if (data.name() == null || data.price() == null || data.quantity() == null)
            throw new ProductMissingFieldsException();

        product.setName(data.name());
        product.setPrice(data.price());
        product.setQuantity(data.quantity());

        return repository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO data) {
        Product product = repository.findById(id).orElseThrow(ProductNotFoundException::new);

        // dessa vez alteramos os dados de um produto já criado e encontrado.
        product.setName(data.name());
        product.setPrice(data.price());
        product.setQuantity(data.quantity());

        // e o salvamos novamente.
        return repository.save(product);
    }

    public Product deleteProduct(Long id) {
        Product product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        repository.delete(product);

        return null;
    }
}
