package com.mdbytes.bbc.dao.store;

import com.mdbytes.bbc.entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StoreDAOImpl implements StoreDAO {

    private EntityManager entityManager;

    @Autowired
    public StoreDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Store store) {
        entityManager.persist(store);
    }

    @Override
    @Transactional
    public Store get(int id) {
        return entityManager.find(Store.class, id);
    }

    @Override
    @Transactional
    public List<Store> getAll() {
        TypedQuery<Store> query = entityManager.createQuery("FROM Store", Store.class);
        List<Store> stores = query.getResultList();
        return stores;
    }

    @Override
    @Transactional
    public void update(Store store) {
        entityManager.merge(store);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Store store = entityManager.find(Store.class, id);
        entityManager.remove(store);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Store").executeUpdate();
        return numRowsDeleted;
    }
}
