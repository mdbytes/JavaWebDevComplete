package com.mdbytes.jpa.dao.Instructor;

import com.mdbytes.jpa.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor get(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> getAll() {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor", Instructor.class);

        // run query
        List<Instructor> instructors = query.getResultList();

        // return query results
        return instructors;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Instructor").executeUpdate();
        return numRowsDeleted;
    }

}
