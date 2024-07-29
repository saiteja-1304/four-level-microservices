package com.microServiceProject.ResultService.repository;

import com.microServiceProject.ResultService.model.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<ResultModel,String> {


    List<ResultModel> findByResultId(String id);

    List<ResultModel> findByAssessmentId(String assessmentId);
}
