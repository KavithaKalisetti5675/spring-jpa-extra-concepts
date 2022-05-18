package com.spring.example2.spring.jpa.repository;

import com.spring.example2.spring.jpa.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id) {
        Course course = entityManager.find(Course.class, id);
        return course;
    }

    public void insert(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
    }

    public boolean deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
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
