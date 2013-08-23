package com.skyworx.shop.service;

import com.skyworx.shop.dao.OrderDao;
import com.skyworx.shop.dao.ProductDao;
import com.skyworx.shop.model.Order;
import com.skyworx.shop.model.OrderItem;
import com.skyworx.shop.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Date;

public class ShopServiceImplTest {

    @Test
    public void testPlaceOrder() throws Exception {
        ShopServiceImpl shopService = new ShopServiceImpl();

        OrderDao orderDao = Mockito.mock(OrderDao.class);
        ProductDao productDao = Mockito.mock(ProductDao.class);

        shopService.orderDao =  orderDao;
        shopService.productDao = productDao;

        Product bateraiAbc = new Product(1L, "Baterai ABC", 3000d, 20);

        Order order = new Order(new Date(), "dadan");
        order.addItem(new OrderItem(1L, "Baterai ABC", 11, 3000d));

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                Order theOrder = (Order) arguments[0];
                theOrder.setId(999L);
                return theOrder;
            }
        }).when(orderDao).save(order);

        Mockito.when(productDao.get(1L)).thenReturn(bateraiAbc);

        shopService.placeOrder(order);

        Assert.assertEquals(9, bateraiAbc.getStock().intValue());

    }
}
