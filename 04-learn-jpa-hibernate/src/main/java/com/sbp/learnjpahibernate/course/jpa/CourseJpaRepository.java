package com.sbp.learnjpahibernate.course.jpa;

import com.sbp.learnjpahibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseJpaRepository {
//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id) {
       return entityManager.find(Course.class, id);
    }

    public List<Course> findAll() {
        String jpql = "SELECT c FROM Course c";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);

        return query.getResultList();
    }


    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
