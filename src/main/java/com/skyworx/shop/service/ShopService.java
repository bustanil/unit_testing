package com.skyworx.shop.service;

import com.skyworx.shop.model.Order;

/**
 * Created with IntelliJ IDEA.
 * User: asus3
 * Date: 22.08.13
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public interface ShopService {
    void placeOrder(Order order);
}
