package com.sbp.learnjpahibernate.course.springdatajpa;

import com.sbp.learnjpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    //Our custom method
    List<Course> findByAuthor(String author);
}
