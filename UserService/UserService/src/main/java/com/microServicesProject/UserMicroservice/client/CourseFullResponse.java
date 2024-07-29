package com.microServicesProject.UserMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFullResponse {
    public String courseId;
    public String courseName;
    public String courseDescription;
    public String courseDuration;
    public String userId;
    public List<AssessmentResponse> assessments;
}
