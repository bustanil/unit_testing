package com.skyworx.shop.service;

import com.skyworx.shop.dao.OrderDao;
import com.skyworx.shop.dao.ProductDao;
import com.skyworx.shop.model.Order;
import com.skyworx.shop.model.OrderItem;
import com.skyworx.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Override
    public void placeOrder(Order order) {
        checkNotNull(order);
        orderDao.save(order);
        for (OrderItem item : order.getItems()) {
            Product product = productDao.get(item.getProductId());
            product.reduceStock(item.getQuantity());
            productDao.save(product);
        }
    }

}
