package com.sbp.learnjpahibernate.course;

import com.sbp.learnjpahibernate.course.Course;
import com.sbp.learnjpahibernate.course.jdbc.CourseJdbcRepository;
import com.sbp.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.sbp.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "AWS Jpa", "SBP"));
//        repository.insert(new Course(2, "GCP Jpa", "SBP"));
//        repository.insert(new Course(3, "Azure Jpa", "SBP"));

        repository.save(new Course(1, "AWS Jpa", "SBP"));
        repository.save(new Course(2, "GCP Jpa", "SBP"));
        repository.save(new Course(3, "Azure Jpa", "SBP"));

        repository.deleteById(1l);

//        System.out.println(repository.findById(2) );
//        System.out.println(repository.findById(3) );
//
//        System.out.println(repository.findAll() );

        System.out.println(repository.findById(1l) );

        System.out.println(repository.count() );

        System.out.println(repository.findByAuthor("SBP") );
    }
}
