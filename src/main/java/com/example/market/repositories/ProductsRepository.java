package com.example.market.repositories;


import com.example.market.models.Products;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import static com.example.market.models.Products.Type.*;

@Component
public class ProductsRepository {
private List<Products> productsList;


@PostConstruct
public void init() {
    productsList = new ArrayList(Arrays.asList(
            new  Products(1L, "Говядина", 30.4D, Мясо),
            new Products(2L, "Баранина", 50.0D, Мясо),
            new Products(3L, "Картошка", 30.0d, Овощи),
            new Products(4L, "Лук", 10, Овощи),
            new Products(5L, "Coca-cola", 10, Напитки),
            new Products(6L, "JackDaniels", 200, Алкоголь),
            new Products(7L,"Булочки",4,Мучное),
            new Products(8L,"Огурцы",20,Овощи)));

}

    public List<Products> getProductsList() {
        return Collections.unmodifiableList(productsList);
    }


    public void removeById(Long id){
    for (Products products: productsList){
        if (products.getId().equals(id)){
            productsList.remove(products);

        }
    }


    }
    public void upperById(Long id) {
        for (Products products : productsList) {
            if (products.getId().equals(id)) {
                products.setCost(products.getCost() + 5);
            }
        }

    }
    public void lowerCost(Long id){
    for(Products products: productsList){
        if(products.getId().equals(id)){
            products.setCost(products.getCost() - 5);
        }
    }
}
}



