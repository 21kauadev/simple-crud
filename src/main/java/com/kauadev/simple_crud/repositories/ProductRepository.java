package com.kauadev.simple_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kauadev.simple_crud.domain.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
