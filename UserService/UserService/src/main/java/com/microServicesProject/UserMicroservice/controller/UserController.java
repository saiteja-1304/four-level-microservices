package com.microServicesProject.UserMicroservice.controller;

import com.microServicesProject.UserMicroservice.client.UserFullResponse;
//import com.microServicesProject.UserMicroservice.dto.UserDto;
import com.microServicesProject.UserMicroservice.model.UserModel;
import com.microServicesProject.UserMicroservice.service.UserService;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
    private UserService userService;

@PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel user) {
    return userService.addUser(user);
    }

    @GetMapping("/getUser/{userId}")
    public UserFullResponse getUser(@PathVariable String userId) {
        return userService.getByUserId(userId);
    }

//    @GetMapping("/getCourses/{courseId}")
//    public List<UserModel> getByCourseId(@PathVariable String courseId) {
//        return userService.getByCourseId(courseId);
//    }
//
//    @GetMapping("/getAssessment/{assessmentId}")
//    public List<UserModel> getByAssessmentId(@PathVariable String assessmentId) {
//        return userService.getByAssessmentId(assessmentId);
//    }


}
