package com.example.market.models;

import lombok.Data;

@Data
public class Products {
    private Long id;
    private String title;
    private double cost;
    private Type type;

    public Products(){

    }
public enum Type{
        Мясо,Овощи,Мучное,Напитки,Алкоголь;

}


    public Products(Long id,String title,double cost,Type type){
        this.cost =cost;
        this.id =id;
        this.title =title;
        this.type=type;
    }
}
