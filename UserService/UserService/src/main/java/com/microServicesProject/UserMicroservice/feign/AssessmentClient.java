package com.microServicesProject.UserMicroservice.feign;

import com.microServicesProject.UserMicroservice.client.AssessmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="AssessmentService",url="http://localhost:9101/assessment")
//@FeignClient(name="AssessmentService", url="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
public interface AssessmentClient {
    @GetMapping("/getByCourseId/{courseId}")
    List<AssessmentResponse> getAssessmentByCourseId(@PathVariable("courseId") String courseId);
}
