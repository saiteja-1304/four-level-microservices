package com.microserviceProject.CourseMicroservice.controller;

import com.microserviceProject.CourseMicroservice.client.CourseFullResponse;
import com.microserviceProject.CourseMicroservice.model.Course;
import com.microserviceProject.CourseMicroservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
        public Course addcourses(@RequestBody Course course){
            return courseService.addCourses(course);
        }

    @GetMapping("/getCourseByUserId/{userId}")
    public CourseFullResponse getCourseByUserId(@PathVariable("userId") String userId){
        return courseService.getCourseByUserId(userId);
    }


}
