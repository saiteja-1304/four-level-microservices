package com.microserviceProject.CourseMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseFullResponse {
    public String courseId;
    public String courseName;
    public String courseDescription;
    public String userId;
    public String courseDuration;
    public List<AssessmentResponse> assessment;
}
