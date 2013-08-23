package com.skyworx.shop.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testAdd3Products() {
        // start with an empty cart
        ShoppingCart cart = new ShoppingCart();

        // add 3 products
        Product sepatuKuda = new Product(1L, "Sepatu Kuda", 100000.00d, 10);
        Product sepatuBola = new Product(2L, "Sepatu Bola", 400000.00d, 5);
        Product sepatuKaca = new Product(3L, "Sepatu Kaca", 200000.00d, 90);
        cart.addProduct(sepatuKuda, 2);
        cart.addProduct(sepatuBola, 1);
        cart.addProduct(sepatuKaca, 10);

        List<OrderItem> items = cart.getItems();

        // make sure there are 3 products in the cart
        Assert.assertEquals(3, items.size());

        Assert.assertEquals(1L, items.get(0).getProductId().longValue());
        Assert.assertEquals(2L, items.get(1).getProductId().longValue());
        Assert.assertEquals(3L, items.get(2).getProductId().longValue());
    }

    @Test
    public void testUpdateItemQuantity(){
        ShoppingCart cart = new ShoppingCart();

        // add 2 products
        Product sepatuKuda = new Product(1L, "Sepatu Kuda", 100000.00d, 10);
        Product sepatuBola = new Product(2L, "Sepatu Bola", 400000.00d, 5);
        cart.addProduct(sepatuKuda, 2);
        cart.addProduct(sepatuBola, 1);

        cart.updateProduct(sepatuBola, 2);

        OrderItem itemSepatuBola = cart.getItems().get(1);
        Assert.assertEquals(2, itemSepatuBola.getQuantity().intValue());
    }

    @Test
    public void addProduct_notEnoughQuantity(){
        ShoppingCart cart = new ShoppingCart();
        Product sepatuKuda = new Product(1L, "Sepatu Kuda", 100000.00d, 10);

        try {
            cart.addProduct(sepatuKuda, 11);
            Assert.fail("should not be called");
        } catch (Exception e) {
            // success
        }


    }

}
