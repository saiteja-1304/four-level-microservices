package com.microServiceProject.ResultService.service;

import com.microServiceProject.ResultService.model.ResultModel;
import com.microServiceProject.ResultService.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultSer {
    @Autowired
    private ResultRepository repo;

    public ResultModel addResult(ResultModel resultModel) {
        return repo.save(resultModel);
    }

    public List<ResultModel> getResultByID(String id) {
       return repo.findByResultId(id);
    }

    public List<ResultModel> getAllResult() {
        return repo.findAll();
    }

    public List<ResultModel> getResultsByAssessmentId(String assessmentId) {
        return repo.findByAssessmentId(assessmentId);
    }
}
