package com.spring.example2.spring.jpa;

import com.spring.example2.spring.jpa.entity.Course;
import com.spring.example2.spring.jpa.entity.Student;
import com.spring.example2.spring.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest(classes = Application.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;


    @Test
    @Transactional
    void testFindById() {
        Student student = em.find(Student.class, 1L);
        Assertions.assertEquals(student.getName(),"James");
    }

    @Test
    void testDeleteById() {
        boolean deleteById = studentRepository.deleteById(2L);
        Assertions.assertEquals(true,deleteById);

    }
}
