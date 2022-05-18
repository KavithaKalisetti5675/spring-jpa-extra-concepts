package com.spring.example2.spring.jpa;

import com.spring.example2.spring.jpa.entity.Passport;
import com.spring.example2.spring.jpa.entity.Student;
import com.spring.example2.spring.jpa.repository.CourseRepository;
import com.spring.example2.spring.jpa.repository.PassportRepository;
import com.spring.example2.spring.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final PassportRepository passportRepository;


    @Autowired
    public Application(CourseRepository courseRepository, StudentRepository studentRepository, PassportRepository passportRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.passportRepository = passportRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
//		courseRepository.insert(new Course("JPA in spring", LocalDateTime.now(),LocalDateTime.now()));
//		courseRepository.insert(new Course("MVC in spring",LocalDateTime.now(),LocalDateTime.now()));
//		courseRepository.insert(new Course("Security in spring",LocalDateTime.now(),LocalDateTime.now()));
//
//
//		Course course = courseRepository.findById(3L);
//		logger.info("course "+  course.getName());
//
//		course.setName("Security in spring - updated");
//
//		courseRepository.deleteById(1L);
        Passport passport = new Passport("Z123456");
        passportRepository.insert(passport);
        studentRepository.insert(new Student("James", passport));
        studentRepository.insert(new Student("Jack", passport));
        studentRepository.insert(new Student("Jake", passport));
    }
}
