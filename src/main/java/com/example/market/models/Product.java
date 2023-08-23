package com.example.market.models;


public class Product {
    private String name;
    private Long id;
    private Long cost;
    private Type type;

    public enum Type {
        МЯСНОЙ, МУЧНОЕ, НАПИТКИ, АЛКОГОЛЬ,ОВОЩИ
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Product() {

    }

    public Product(Long id, String name, Long cost, Type type) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.type = type;
    }


}