package com.example.market.repositories;

import com.example.market.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> productList;


    @PostConstruct
    public void init(){
        productList = new ArrayList<>(List.of(
                new Product(1L,"Говядина",30L, Product.Type.МЯСНОЙ),
                new Product(2L,"Баранина",50L, Product.Type.МЯСНОЙ),
                new Product(3L,"Курица",40L, Product.Type.МЯСНОЙ),
                new Product(4L,"Батон",20L, Product.Type.МЯСНОЙ),
                new Product(5L,"Хлеб",20L, Product.Type.МЯСНОЙ),
                new Product(6L,"Булочки",100L, Product.Type.МЯСНОЙ),
                new Product(7L,"Картошка",20L, Product.Type.МЯСНОЙ),
                new Product(8L,"Лук",400L, Product.Type.ОВОЩИ)

                ));

    }
    public List<Product> getProductList(){
        return Collections.unmodifiableList(productList);
    }
}
