package com.microServicesProject.UserMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullResponse {
    private String userId;
    private String name;
    private String email;
    private String education;
    public CourseFullResponse courses;

}
