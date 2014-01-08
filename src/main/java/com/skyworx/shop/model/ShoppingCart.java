package com.skyworx.shop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skyworx.shop.ShoppingCartException;

public class ShoppingCart {

    private String customerName;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

	public void addProduct(Product product, int quantity) {
		if(getProductQuantity(product.getId()) + quantity > product.getStock()){
			throw new ShoppingCartException("Not enough stock");
		}
		try {
			OrderItem item = searchItem(product.getId());
			updateQuantity(product.getId(), item.getQuantity() + quantity);
		} catch (ShoppingCartException e) {
			// exception means the product cannot be found
			OrderItem item = new OrderItem(product.getId(), product.getName(), quantity, product.getPrice());
			items.add(item);
		}
	}

	public int getProductQuantity(long productId) {
		try {
			return searchItem(productId).getQuantity();
		} catch (ShoppingCartException e) {
			return 0;
		}
	}
	
	private OrderItem searchItem(long productId){
		for (OrderItem item : items) {
			if(item.getProductId() == productId){
				return item;
			}
		}
		throw new ShoppingCartException("Invalid product id: " + productId);
	}

	public void updateQuantity(long productId, int quantity) {
		searchItem(productId).setQuantity(quantity);
	}

}
