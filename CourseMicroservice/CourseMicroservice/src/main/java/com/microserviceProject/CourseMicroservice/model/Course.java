package com.microserviceProject.CourseMicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Courses")
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String courseDescription;
    private String courseDuration;
    private String userId;

}
