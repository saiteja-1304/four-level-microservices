package com.microServiceProject.AssessmentService.repository;

import com.microServiceProject.AssessmentService.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssessmentRepository extends JpaRepository<Assessment,String> {
    Optional<Assessment> findByAssessmentId(String courseId);

    List<Assessment> findByCourseId(String courseId);

   // List<Assessment> findByResultId(String resultId);
}
