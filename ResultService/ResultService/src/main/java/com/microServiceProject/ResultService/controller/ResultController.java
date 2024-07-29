package com.microServiceProject.ResultService.controller;

import com.microServiceProject.ResultService.model.ResultModel;
import com.microServiceProject.ResultService.service.ResultSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultSer resultService;

    @PostMapping("/addResult")
    public ResultModel addResult( @RequestBody ResultModel resultModel){
        return resultService.addResult(resultModel);
    }

    @GetMapping("/getResultByID/{resultId}")
    public List<ResultModel> getResultByID(@PathVariable("resultId") String id){
        return resultService.getResultByID(id);
    }

    @GetMapping("/getAllResult")
    public List<ResultModel> getAllResult(){
        return resultService.getAllResult();
    }

    @GetMapping("/getResultsByAssessmentId/{assessmentId}")
        public List<ResultModel> getResultsByAssessmentId(@PathVariable("assessmentId") String assessmentId){
            return resultService.getResultsByAssessmentId(assessmentId);
        }

}
