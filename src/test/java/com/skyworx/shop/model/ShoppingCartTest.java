package com.skyworx.shop.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.skyworx.shop.ShoppingCartException;


public class ShoppingCartTest {

	private Product sonyBraviaTV;
	private ShoppingCart cart;
	
	private static final long TEST_PRODUCT_ID = 1L;
	
	@Before
	public void prepareTestProduct(){
		sonyBraviaTV = new Product(TEST_PRODUCT_ID, "Sony Bravia TV 24\"", 2000000.00, 5);
		cart = new ShoppingCart();
	}

	@Test
    public void testAddNormalOrder(){
    	cart.addProduct(sonyBraviaTV, 3);
    	assertEquals(3, cart.getProductQuantity(TEST_PRODUCT_ID));
	}
	
	@Test
	public void testUpdateOrderItemQuantity(){
    	cart.addProduct(sonyBraviaTV, 3);
    	cart.updateQuantity(TEST_PRODUCT_ID, 2);
    	assertEquals(2, cart.getProductQuantity(TEST_PRODUCT_ID));
	}
	
	@Test
	public void testAddExistingProduct(){
    	cart.addProduct(sonyBraviaTV, 3);
    	cart.addProduct(sonyBraviaTV, 2);
    	assertEquals(5, cart.getProductQuantity(TEST_PRODUCT_ID));
	}
	
	@Test(expected = ShoppingCartException.class)
	public void testNotEnoughStock(){
		cart.addProduct(sonyBraviaTV, 6);
	}
	
	@Test(expected = ShoppingCartException.class)
	public void testDoubleAddProductNotEnoughStock(){
		cart.addProduct(sonyBraviaTV, 3);
    	cart.addProduct(sonyBraviaTV, 3);
	}

}
