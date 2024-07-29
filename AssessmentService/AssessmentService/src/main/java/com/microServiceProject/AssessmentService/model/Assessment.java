package com.microServiceProject.AssessmentService.model;

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
@Table(name = "assessment")
public class Assessment {
    @Id
    private String assessmentId;
    private String assessmentName;
    private String assessmentDescription;
    private String assessmentType;
    private String assessmentDuration;
    private String courseId;

}
