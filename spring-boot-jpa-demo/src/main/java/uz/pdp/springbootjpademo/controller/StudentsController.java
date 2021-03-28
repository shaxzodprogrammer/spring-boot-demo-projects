package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.MentorsDto;
import uz.pdp.springbootjpademo.payload.StudentsDto;
import uz.pdp.springbootjpademo.service.MentorsService;
import uz.pdp.springbootjpademo.service.StudentsService;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @PostMapping("/saveOrEditStudents")
    public HttpEntity<?> saveOrEditDistrict(@RequestBody StudentsDto studentsDto) {
        ApiResponse apiResponse = studentsService.saveOrEditStudents(studentsDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteStudents/{id}")
    public HttpEntity<?> removeGroups(@PathVariable(value = "id") Integer id){
        ApiResponse apiResponse =studentsService.deleteStudents(id);
        return ResponseEntity
                .status(apiResponse.isSuccess()  ?200 : 409)
                .body(apiResponse);
    }
}
