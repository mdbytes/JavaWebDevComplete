package com.mdbytes.bbc.dao.user;

import com.mdbytes.bbc.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        String hashedPassword = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(hashedPassword);
        entityManager.persist(user);
    }


    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from User").executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public boolean validateUser(String userName, String password) {
        return false;
    }

    @Override
    public void makeUserAdmin(User user) {

    }
}
