package com.microServiceProject.AssessmentService.controller;

import com.microServiceProject.AssessmentService.client.AssessmentRepsonse;
import com.microServiceProject.AssessmentService.model.Assessment;
import com.microServiceProject.AssessmentService.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/addAssessment")
    public Assessment addAssessment(@RequestBody Assessment assessment){
        return assessmentService.addAssessment(assessment);
    }

    @GetMapping("/getById/{assessmentId}")
    public AssessmentRepsonse getAssessmentById(@PathVariable("assessmentId") String assessmentId){
        return assessmentService.getbyAssessmentId(assessmentId);
    }

    @GetMapping("/getByCourseId/{courseId}")
    public List<Assessment> getAssessmentByCourseId(@PathVariable("courseId") String courseId){
        return assessmentService.getByCourseId(courseId);
    }
//    @GetMapping("/getByResultId/{resultId}")
//    public List<Assessment> getAssessmentByResultId(@PathVariable("resultId") String resultId){
//        return assessmentService.getByResultId(resultId);
//    }

}
