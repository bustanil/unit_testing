package com.skyworx.shop.service;

import com.skyworx.shop.BaseTransactionalTest;
import com.skyworx.shop.dao.OrderDao;
import com.skyworx.shop.dao.ProductDao;
import com.skyworx.shop.model.Order;
import com.skyworx.shop.model.OrderItem;
import com.skyworx.shop.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopServiceImplIntegrationTest extends BaseTransactionalTest {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    ShopService shopService;

    @Test
    public void testPlaceOrder() throws Exception {
        Product bateraiAbc = new Product(null, "Baterai ABC", 3000d, 20);
        productDao.save(bateraiAbc);

        Order order = new Order(new Date(), "dadan");
        order.addItem(new OrderItem(bateraiAbc.getId(), bateraiAbc.getName(), 11, bateraiAbc.getPrice()));

        shopService.placeOrder(order);

        Assert.assertEquals(9, productDao.get(bateraiAbc.getId()).getStock().intValue());
    }
}
