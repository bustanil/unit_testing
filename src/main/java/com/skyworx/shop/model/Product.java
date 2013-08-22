package com.skyworx.shop.model;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private Integer stock;

    public Product(Long id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void reduceQuantity(Integer quantity) {
        if(stock < quantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        stock = stock - quantity;
    }
}