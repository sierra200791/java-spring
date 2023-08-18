package com.example.market.controllers;

import com.example.market.models.Products;
import com.example.market.repositories.ProductsRepository;
import com.example.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProductsController {
private ProductsService productsService;
//
@Autowired
    public ProductsController(ProductsService productsService){
       this.productsService = productsService;

   }

    @GetMapping("/")
    public String home(){
        return "home";

    }
    @GetMapping("/products")

    public List<Products> productPage() {
        return productsService.findAll();
    }


    @GetMapping("/product/{id}/info")
    public String infoPage(Model model, @PathVariable Long id) {
    Products products = productsService.findById(id);
        model.addAttribute("info", products);
        return "infoPage";
    }
}
