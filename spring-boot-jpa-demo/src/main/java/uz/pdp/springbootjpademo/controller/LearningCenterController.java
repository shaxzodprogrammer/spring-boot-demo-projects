package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.GroupsDto;
import uz.pdp.springbootjpademo.service.GroupsService;

@RestController
@RequestMapping("/api/learningCenter")
public class LearningCenterController {
    @Autowired
    GroupsService groupsService;

    @PostMapping("/saveOrEditLearningCenter")
    public HttpEntity<?> saveOrEditDistrict(@RequestBody GroupsDto groupsDto) {
        ApiResponse apiResponse = groupsService.saveOrEditGroups(groupsDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteLearningCenter/{id}")
    public HttpEntity<?> removeGroups(@PathVariable(value = "id") Integer id){
        ApiResponse apiResponse = groupsService.deleteGroups(id);
        return ResponseEntity
                .status(apiResponse.isSuccess()  ?200 : 409)
                .body(apiResponse);
    }
}
