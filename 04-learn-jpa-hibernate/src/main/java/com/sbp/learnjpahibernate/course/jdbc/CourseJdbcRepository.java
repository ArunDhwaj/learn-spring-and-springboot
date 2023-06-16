package com.sbp.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sbp.learnjpahibernate.course.Course;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String Insert_Query =
            """
            insert into course(id, name, author) values(?, ?, ? );
            """;
    private static String Delete_Query =
            """
            delete from Course
            where id =?
            """;
    private static String Select_Query =
            """
            Select * from Course
            where id =?
            """;

    public void insert(Course course)
    {
        springJdbcTemplate.update(Insert_Query, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id)
    {
        springJdbcTemplate.update(Delete_Query, id);
    }

    public Course findById(long id)
    {
        return springJdbcTemplate.queryForObject(Select_Query, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
