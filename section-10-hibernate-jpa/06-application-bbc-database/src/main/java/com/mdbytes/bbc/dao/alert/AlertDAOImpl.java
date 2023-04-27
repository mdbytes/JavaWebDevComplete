package com.mdbytes.bbc.dao.alert;

import com.mdbytes.bbc.entity.Alert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AlertDAOImpl implements AlertDAO {

    private EntityManager entityManager;

    @Autowired
    public AlertDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Alert alert) {
        entityManager.persist(alert);
    }

    @Override
    public Alert get(int id) {
        return entityManager.find(Alert.class, id);
    }

    @Override
    public List<Alert> getAll() {
        TypedQuery<Alert> query = entityManager.createQuery("FROM Alert", Alert.class);
        List<Alert> alerts = query.getResultList();
        return alerts;
    }

    @Override
    @Transactional
    public void update(Alert alert) {
        entityManager.merge(alert);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Alert alert = entityManager.find(Alert.class, id);
        entityManager.remove(alert);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Alert").executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public int sendAlertNotifications() {
        return 0;
    }
}
