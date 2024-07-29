package com.microServiceProject.ResultService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "result")
public class ResultModel {
    @Id
    public String resultId;
    public String result;
    public String assessmentId;
    public String resultduration;
    public String resultdate;
    public int cutOffPercentage;
}
