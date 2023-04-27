package com.mdbytes.app.dao;

import com.mdbytes.app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
            entityManager.persist(student);
    }

    @Override
    public Student get(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAll() {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName",Student.class);

        // run query
        List<Student> students = query.getResultList();

        // return query results
        return students;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName =:theData",Student.class);
        query.setParameter("theData",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        // retrieve the student
        Student student = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }


}
