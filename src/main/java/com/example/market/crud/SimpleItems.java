package com.example.market.crud;


import jakarta.persistence.*;

@Entity
@Table(name = "simple_items")

public class SimpleItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    public SimpleItems() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice(int price) {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SimpleItems{" +
                "id: " + id +
                ", title: '" + title + '\'' +
                ", price: " + price +
                '}';
    }
}

