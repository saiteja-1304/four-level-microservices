package com.microserviceProject.CourseMicroservice.service;

import com.microserviceProject.CourseMicroservice.client.CourseFullResponse;
import com.microserviceProject.CourseMicroservice.client.AssessmentResponse;
import com.microserviceProject.CourseMicroservice.client.ResultModel;
import com.microserviceProject.CourseMicroservice.feign.AssessmentClient;
import com.microserviceProject.CourseMicroservice.feign.ResultClient;
import com.microserviceProject.CourseMicroservice.model.Course;
import com.microserviceProject.CourseMicroservice.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private AssessmentClient client;

    @Autowired
    private ResultClient resultClient;
    public Course addCourses(Course course) {
        return courseRepo.save(course);
    }



//    public List<ArrayList<CourseFullResponse>> getCourseByUserId(String userId) {
//        List<Course> courses = courseRepo.findByUserId(userId);
//        ArrayList<ArrayList<CourseFullResponse>> responses = new ArrayList<>();
//        for(Course c :courses) {
//            List<AssessmentResponse> list = client.getAssessmentByCourseId(c.getCourseId());
//            CourseFullResponse res = new CourseFullResponse();
//            res.setCourseId(c.getCourseId());
//            res.setCourseName(c.getCourseName());
//            res.setCourseDescription(c.getCourseDescription());
//            res.setCourseDuration(c.getCourseDuration());
//            res.setUserId(c.getUserId());
//
//            List<AssessmentResponse> re = new ArrayList<>();
//            for(AssessmentResponse a : list) {
//                List<ResultModel> innerList=resultClient.getResultsByAssessmentId(a.getAssessmentId());
//                AssessmentResponse assmt=new AssessmentResponse();
//                assmt.setAssessmentId(a.getAssessmentId());
//                assmt.setAssessmentName(a.getAssessmentName());
//                assmt.setAssessmentDescription(a.getAssessmentDescription());
//                assmt.setAssessmentType(a.getAssessmentType());
//                assmt.setAssessmentDuration(a.getAssessmentDuration());
//                assmt.setCourseId(a.getCourseId());
//                assmt.setResults(innerList);
//                re.add(assmt);
//                res.setAssessment(re);
//            }
//            responses.add((ArrayList) re);
//        }
//        return responses;
//    }
        public CourseFullResponse getCourseByUserId(String userId) {
            List<Course> courses = courseRepo.findByUserId(userId);
            CourseFullResponse courseres = new CourseFullResponse();
            for(Course c :courses) {
                List<AssessmentResponse> list = client.getAssessmentByCourseId(c.getCourseId());
                courseres.setCourseId(c.getCourseId());
                courseres.setCourseName(c.getCourseName());
                courseres.setCourseDescription(c.getCourseDescription());
                courseres.setCourseDuration(c.getCourseDuration());
                courseres.setUserId(c.getUserId());
                courseres.setAssessment(list);
                for(AssessmentResponse a : list) {
                    List<ResultModel> results = resultClient.getResultsByAssessmentId(a.getAssessmentId());
                    a.setResults(results);
                }
            }
            return courseres;
            //List<AssessmentResponse> assessments = client.getAssessmentByCourseId(courseId);
        }
}
