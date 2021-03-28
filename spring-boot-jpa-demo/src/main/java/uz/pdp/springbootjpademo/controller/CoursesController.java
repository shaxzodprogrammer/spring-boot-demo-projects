package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.CoursesDto;
import uz.pdp.springbootjpademo.service.CoursesService;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    @Autowired
    CoursesService  coursesService;

    @PostMapping("/saveOrEditCourses")
    public HttpEntity<?> saveOrEditDistrict(@RequestBody CoursesDto coursesDto) {
        ApiResponse apiResponse = coursesService.saveOrEditDistrict(coursesDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteCourses/{id}")
    public HttpEntity<?> removeDistrict(@PathVariable(value = "id") Integer id){
        ApiResponse apiResponse = coursesService.deleteCourses(id);
        return ResponseEntity
                .status(apiResponse.isSuccess()  ?200 : 409)
                .body(apiResponse);
    }
}
