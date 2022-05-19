package com.spring.example2.spring.jpa.repository;

import com.spring.example2.spring.jpa.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Student findById(Long id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    public void insert(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
    }

    public boolean deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
        return true;
    }

//    public void playWithEntityManager() {
//        Course course1 = new Course("Web Services in 100 Steps");
//        entityManager.persist(course1);
//        entityManager.flush();
//
//        course1.setName("Web Services in 100 Steps - updated");
//        entityManager.flush();
//
//        Course course2 = findById(1L);
//        entityManager.detach(course2);
//        course2.setName("JPA in 50 Steps - Updated");
//    }
}
