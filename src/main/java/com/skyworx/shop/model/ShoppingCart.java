package com.skyworx.shop.model;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ShoppingCart {

    private String customerName;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @SuppressWarnings("unchecked")
    public List<OrderItem> getItems() {
        return items;
    }

    public void addProduct(Product product, Integer quantity) {
        if(product.getStock() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }
        checkNotNull(product, "Product cannot be null");
        OrderItem item = searchItemByProductId(product.getId());
        if(item == null){
            item = new OrderItem();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(quantity);
            items.add(item);
        }
        else {
            item.addQuantity(quantity);
        }
    }

    public void updateProduct(Product product, Integer quantity) {
        checkNotNull(product, "Product cannot be null");
        OrderItem item = searchItemByProductId(product.getId());
        if(item == null) {
            throw new IllegalArgumentException("Product not found!");
        }
        else {
            item.setQuantity(quantity);
        }
    }

    public void removeProduct(Product product){
        OrderItem item = searchItemByProductId(product.getId());
        if(item != null) {
            items.remove(item);
        }
        else {
            throw new IllegalArgumentException("Product not found!");
        }
    }

    private OrderItem searchItemByProductId(Long productId) {
        for (OrderItem item : items) {
            if(item.getProductId().equals(productId)){
                return item;
            }
        }
        return null;
    }

    public Order createOrder(){
        Order order = new Order();
        order.setDate(new Date());
        order.setCustomerName(customerName);
        order.setItems(items);
        return order;
    }

}
