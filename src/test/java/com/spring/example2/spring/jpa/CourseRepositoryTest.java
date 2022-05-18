package com.spring.example2.spring.jpa;

import com.spring.example2.spring.jpa.entity.Course;
import com.spring.example2.spring.jpa.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;


    @Test
    void testFindById() {
        Course course = courseRepository.findById(2L);
        Assertions.assertEquals(course.getName(),"MVC in spring");
    }

    @Test
    void testDeleteById() {
        boolean deleteById = courseRepository.deleteById(2L);
        Assertions.assertEquals(true,deleteById);

    }
}
