package com.mdbytes.jpa.dao.instructordetail;

import com.mdbytes.jpa.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDetailDAOImpl implements InstructorDetailDAO {

    private EntityManager entityManager;

    @Autowired
    public InstructorDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(InstructorDetail detail) {
        entityManager.persist(detail);
    }

    @Override
    public InstructorDetail get(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public List<InstructorDetail> getAll() {
        TypedQuery<InstructorDetail> query = entityManager.createQuery("FROM InstructorDetail", InstructorDetail.class);

        // run query
        List<InstructorDetail> details = query.getResultList();

        // return query results
        return details;
    }

    @Override
    @Transactional
    public void update(InstructorDetail detail) {
        entityManager.merge(detail);
    }

    @Override
    @Transactional
    public void delete(int id) {
        InstructorDetail instructor = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from InstructorDetail").executeUpdate();
        return numRowsDeleted;
    }

}
