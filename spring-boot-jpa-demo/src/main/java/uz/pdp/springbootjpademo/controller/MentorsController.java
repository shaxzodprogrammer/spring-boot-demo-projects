package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.GroupsDto;
import uz.pdp.springbootjpademo.payload.MentorsDto;
import uz.pdp.springbootjpademo.service.GroupsService;
import uz.pdp.springbootjpademo.service.MentorsService;

@RestController
@RequestMapping("/api/mentors")
public class MentorsController {
    @Autowired
    MentorsService mentorsService;

    @PostMapping("/saveOrEditMentors")
    public HttpEntity<?> saveOrEditDistrict(@RequestBody MentorsDto mentorsDto) {
        ApiResponse apiResponse = mentorsService.saveOrEditMentors(mentorsDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteMentors/{id}")
    public HttpEntity<?> removeGroups(@PathVariable(value = "id") Integer id){
        ApiResponse apiResponse = mentorsService.deleteMentors(id);
        return ResponseEntity
                .status(apiResponse.isSuccess()  ?200 : 409)
                .body(apiResponse);
    }
}
