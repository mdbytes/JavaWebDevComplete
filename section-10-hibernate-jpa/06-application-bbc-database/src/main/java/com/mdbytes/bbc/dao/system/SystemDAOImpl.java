package com.mdbytes.bbc.dao.system;

import com.mdbytes.bbc.entity.SystemUpdate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SystemDAOImpl implements SystemDAO {

    private EntityManager entityManager;

    @Autowired
    public SystemDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(SystemUpdate update) {
        entityManager.persist(update);
    }

    @Override
    @Transactional
    public SystemUpdate get(int id) {
        return entityManager.find(SystemUpdate.class, id);
    }

    @Override
    @Transactional
    public List<SystemUpdate> getAll() {
        TypedQuery<SystemUpdate> query = entityManager.createQuery("FROM SystemUpdate", SystemUpdate.class);
        List<SystemUpdate> updates = query.getResultList();
        return updates;
    }

    @Override
    @Transactional
    public void update(SystemUpdate update) {
        entityManager.merge(update);
    }

    @Override
    @Transactional
    public void delete(int id) {
        SystemUpdate update = entityManager.find(SystemUpdate.class, id);
        entityManager.remove(update);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from SystemUpdate").executeUpdate();
        return numRowsDeleted;
    }
}
