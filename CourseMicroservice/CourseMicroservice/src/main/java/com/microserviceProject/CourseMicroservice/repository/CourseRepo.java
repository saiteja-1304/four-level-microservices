package com.microserviceProject.CourseMicroservice.repository;


import com.microserviceProject.CourseMicroservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course,String> {
   // Optional<Course> findByCourseId(String courseId);

    List<Course> findByUserId(String userId);
}
