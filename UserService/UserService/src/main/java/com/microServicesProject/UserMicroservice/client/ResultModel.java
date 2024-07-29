package com.microServicesProject.UserMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultModel {
    public String resultId;
    public String result;
    public String assessmentId;
    public String resultduration;
    public String resultdate;
    public int cutOffPercentage;
}
