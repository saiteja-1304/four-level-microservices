package com.microserviceProject.CourseMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentResponse {
    public String assessmentId;
    public String assessmentName;
    public String assessmentDescription;
    public String assessmentType;
    public String assessmentDuration;
    public String courseId;
    public List<ResultModel> results;
}
