package com.example.market.controllers;

import com.example.market.models.Products;
import com.example.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;


@Controller
public class ProductsController {
private ProductsRepository productsRepository;

@Autowired
    public ProductsController(ProductsRepository productsRepository){
        this.productsRepository =  productsRepository;
    }

    @GetMapping("/")
    public String home(){
        return "home";

    }
    @GetMapping("/products")

    public String productPage(Model model) {
        model.addAttribute("meat",productsRepository.getProductsList().stream().filter(x->x.getType().equals(Products.Type.Мясо)).collect(Collectors.toList()));
        model.addAttribute("vegetables",productsRepository.getProductsList().stream().filter(x->x.getType().equals(Products.Type.Овощи)).collect(Collectors.toList()));
        model.addAttribute("drinks",productsRepository.getProductsList().stream().filter(x->x.getType().equals(Products.Type.Напитки)).collect(Collectors.toList()));
        model.addAttribute("alcohol",productsRepository.getProductsList().stream().filter(x->x.getType().equals(Products.Type.Алкоголь)).collect(Collectors.toList()));
        model.addAttribute("flour",productsRepository.getProductsList().stream().filter(x->x.getType().equals(Products.Type.Мучное)).collect(Collectors.toList()));
        return "products";
    }


    @GetMapping("/product/{id}/info")
    public String infoPage(Model model, @PathVariable Long id) {
    Products products = productsRepository.findById(id);
        model.addAttribute("info", products);
        return "infoPage";
    }
}
