package com.microServiceProject.AssessmentService.Feign;

import com.microServiceProject.AssessmentService.client.ResultModel;
import com.microServiceProject.AssessmentService.model.Assessment;
import com.microServiceProject.AssessmentService.service.AssessmentService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ResultService", url = "http://localhost:9100/result")
public interface ResultClient {
//    @GetMapping("/getResultByID/{resultId}")
//    public List<ResultModel> getResultByID(@PathVariable("resultId") String resultId );
@GetMapping("/getResultsByAssessmentId/{assessmentId}")
 List<ResultModel> getResultsByAssessmentId(@PathVariable("assessmentId") String assessmentId);
}
