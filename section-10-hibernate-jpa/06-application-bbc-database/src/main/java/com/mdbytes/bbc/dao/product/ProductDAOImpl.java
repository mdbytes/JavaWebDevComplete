package com.mdbytes.bbc.dao.product;

import com.mdbytes.bbc.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public Product get(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Product").executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public boolean updateProductPrice(Product product) {
        return false;
    }

    @Override
    public boolean updateProductName(String productUrl) {
        return false;
    }
}
