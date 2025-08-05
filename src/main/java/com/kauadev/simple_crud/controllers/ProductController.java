package com.kauadev.simple_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kauadev.simple_crud.domain.product.Product;
import com.kauadev.simple_crud.domain.product.ProductDTO;
import com.kauadev.simple_crud.infra.ApiResponse;
import com.kauadev.simple_crud.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiResponse<List<Product>> response = new ApiResponse<List<Product>>(HttpStatus.OK.value(), true,
                "Produtos retornados: ",
                products);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        ApiResponse<Product> response = new ApiResponse<Product>(200, true, "Produto encontrado:", product);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody ProductDTO data) {
        Product product = productService.createProduct(data);
        ApiResponse<Product> response = new ApiResponse<Product>(200, true, "Produto criado.", product);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable("id") Long id,
            @RequestBody ProductDTO data) {
        Product updatedProduct = productService.updateProduct(id, data);
        ApiResponse<Product> response = new ApiResponse<Product>(200, true, "Produto atualizado", updatedProduct);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        ApiResponse<Product> response = new ApiResponse<Product>(200, true, "Produto deletado", null);

        return ResponseEntity.ok().body(response);
    }

}
