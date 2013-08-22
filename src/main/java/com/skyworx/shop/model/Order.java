package com.skyworx.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Long id;
    private Date date;
    private String customerName;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
