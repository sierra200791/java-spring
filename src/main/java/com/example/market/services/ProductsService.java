package com.example.market.services;

import com.example.market.models.Products;
import com.example.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
    public Iterable<Products> filterByType(Products.Type type){
List<Products> products = productsRepository.getProductsList();
        return products.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }


    public void upperCost (Long id){
      productsRepository.upperById(id);
    }
    public void lowerCost (Long id){
        productsRepository.lowerCost(id);
    }
    public void removeItem(Long id){
        productsRepository.removeById(id);
}}


