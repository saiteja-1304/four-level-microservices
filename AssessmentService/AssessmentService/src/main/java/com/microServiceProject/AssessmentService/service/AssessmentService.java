package com.microServiceProject.AssessmentService.service;

import com.microServiceProject.AssessmentService.Feign.ResultClient;
import com.microServiceProject.AssessmentService.client.AssessmentRepsonse;
import com.microServiceProject.AssessmentService.client.ResultModel;
import com.microServiceProject.AssessmentService.model.Assessment;
import com.microServiceProject.AssessmentService.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private  AssessmentRepository repo;

    @Autowired
    private  ResultClient client;

    public Assessment addAssessment(Assessment assessment) {
       return repo.save(assessment);
    }

    public AssessmentRepsonse getbyAssessmentId(String assessmentId) {
        Assessment a = repo.findByAssessmentId(assessmentId).orElse(null);
        List<ResultModel> list = client.getResultsByAssessmentId(assessmentId);
        AssessmentRepsonse res = new AssessmentRepsonse();
        if(a!=null){
            res.setAssessmentId(a.getAssessmentId());
            res.setAssessmentDuration(a.getAssessmentDuration());
            res.setAssessmentType(a.getAssessmentType());
            res.setAssessmentName(a.getAssessmentName());
            res.setAssessmentDescription(a.getAssessmentDescription());
            res.setCourseId(a.getCourseId());
            res.setResults(list);
        }
        return res;
    }

    public List<Assessment> getByCourseId(String courseId) {
        return repo.findByCourseId(courseId);
    }

//    public List<Assessment> getByResultId(String resultId) {
//        return repo.findByResultId(resultId);
//    }
}
