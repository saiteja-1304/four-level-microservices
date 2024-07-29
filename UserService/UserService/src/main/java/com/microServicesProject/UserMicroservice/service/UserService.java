package com.microServicesProject.UserMicroservice.service;

import com.microServicesProject.UserMicroservice.client.AssessmentResponse;
import com.microServicesProject.UserMicroservice.client.CourseFullResponse;
import com.microServicesProject.UserMicroservice.client.UserFullResponse;
//import com.microServicesProject.UserMicroservice.dto.UserDto;
import com.microServicesProject.UserMicroservice.feign.AssessmentClient;
import com.microServicesProject.UserMicroservice.feign.CourseClient;
import com.microServicesProject.UserMicroservice.feign.ResultClient;
import com.microServicesProject.UserMicroservice.model.UserModel;
import com.microServicesProject.UserMicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseClient courseClient;

    @Autowired
    private AssessmentClient assessmentClient;

    @Autowired
    private ResultClient resClient;



    //    public UserModel addUser(UserDto userdto) {
//        UserModel userModel = UserModel.builder()
//        .userId(userdto.getUserId())
//        .name(userdto.getName())
//        .email(userdto.getEmail())
//                .course(userdto.getCourse())
//                .courseId(userdto.getCourseId())
//                .education(userdto.getEducation())
//                .assessmentId(userdto.getAssessmentId())
//                .assessmentName(userdto.getAssessmentName())
//                .build();
//        return userRepository.save(userModel);
    //   }
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

//        public List<UserModel> getByCourseId (String courseId){
//            return userRepository.findByCourseId(courseId);
//        }
//
//        public List<UserModel> getByAssessmentId (String assessmentId){
//            return userRepository.findByAssessmentId(assessmentId);
//        }

//    public UserFullResponse getByUserId(String userId) {
//        UserModel u = userRepository.findByUserId(userId);
//        UserFullResponse res = new UserFullResponse();
//        List<CourseResponse> list = courseClient.getCourseByUserId(u.getUserId());
//        //UserFullResponse res = new UserFullResponse();
//        res.setUserId(u.getUserId());
//        res.setName(u.getName());
//        res.setEmail(u.getEmail());
//        res.setEducation(u.getEducation());
//        res.setCourses(list);
//        for(CourseResponse c : list) {
//            List<AssessmentResponse> list1 = assessmentClient.getAssessmentByCourseId(c.getCourseId());
//            c.setAssessments(list1);
//            for(AssessmentResponse a : list1) {
//                List<ResultModel> results = resClient.getResultsByAssessmentId(a.getAssessmentId());
//                a.setResults(results);
//            }
//        }
//        return res;
//    }

    public UserFullResponse getByUserId(String userId){
        Optional<UserModel> user = userRepository.findByUserId(userId);
        if(user.isPresent()) {
            UserModel u = user.get();
            CourseFullResponse ces = courseClient.getCourseByUserId(userId);
           UserFullResponse response = new UserFullResponse();
            response.setUserId(u.getUserId());
            response.setName(u.getName());
            response.setEmail(u.getEmail());
            response.setEducation(u.getEducation());
            response.setCourses(ces);
            ces.setAssessments(assessmentClient.getAssessmentByCourseId(ces.getCourseId()));
            for(AssessmentResponse assessment : ces.getAssessments()) {
                assessment.setResults(resClient.getResultsByAssessmentId(assessment.getAssessmentId()));
            }
            return response;
       }
        return null;
        }
//    public CompanyResponse getCompanyHierarchy(Long companyId) {
//        Optional<Company> companyOpt = companyRepository.findById(companyId);
//        if (companyOpt.isPresent()) {
//            Company company = companyOpt.get();
//            List<VerticalResponse> verticals = verticalClient.getVerticalsByCompanyId(companyId);
//            CompanyResponse response = new CompanyResponse();
//            response.setId(company.getId());
//            response.setName(company.getName());
//            response.setVerticals(verticals);
//            return response;
//        }
//        return null;
//    }















//    public CourseFullResponse getCourseByUserId(String userId) {
//        List<Course> courses = courseRepo.findByUserId(userId);
//        CourseFullResponse courseres = new CourseFullResponse();
//        for(Course c :courses) {
//            List<AssessmentResponse> list = client.getAssessmentByCourseId(c.getCourseId());
//            courseres.setCourseId(c.getCourseId());
//            courseres.setCourseName(c.getCourseName());
//            courseres.setCourseDescription(c.getCourseDescription());
//            courseres.setCourseDuration(c.getCourseDuration());
//            courseres.setUserId(c.getUserId());
//            courseres.setAssessment(list);
//            for(AssessmentResponse a : list) {
//                List<ResultModel> results = resultClient.getResultsByAssessmentId(a.getAssessmentId());
//                a.setResults(results);
//            }
//        }
//        return courseres;
//        //List<AssessmentResponse> assessments = client.getAssessmentByCourseId(courseId);
//    }

}