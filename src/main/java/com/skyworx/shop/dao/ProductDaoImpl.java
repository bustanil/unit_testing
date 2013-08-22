package com.skyworx.shop.dao;

import com.skyworx.shop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Product product) {
        getSession().saveOrUpdate(product);
    }

    @Override
    public Product get(Long productId) {
        return (Product) getSession().get(Product.class, productId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> list() {
        return getSession().createCriteria(Product.class).list();
    }

}
