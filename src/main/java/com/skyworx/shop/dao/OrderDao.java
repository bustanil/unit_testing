package com.skyworx.shop.dao;

import com.skyworx.shop.model.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asus3
 * Date: 22.08.13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {
    void save(Order order);

    Order get(Long orderId);

    @SuppressWarnings("unchecked")
    List<Order> list();

    Order findByCustomerName(String customerName);
}
