package com.skyworx.shop.dao;

import com.skyworx.shop.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Order order) {
        getSession().saveOrUpdate(order);
    }

    @Override
    public Order get(Long orderId) {
        return (Order) getSession().get(Order.class, orderId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> list() {
        return getSession().createCriteria(Order.class).list();
    }

    @Override
    public Order findByCustomerName(String customerName) {
        return (Order) getSession()
                .createCriteria(Order.class)
                .add(Restrictions.eq("customerName", customerName))
        .uniqueResult();
    }

}
