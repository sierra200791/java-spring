package com.example.market.services;

import com.example.market.models.Products;
import com.example.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;


    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
}

    public List<Products>findAll(){
       return productsRepository.getProductsList();
}
    public Products findById(Long id) {
        return productsRepository.getProductsList().stream().filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found by id: " + id));
    }
}
