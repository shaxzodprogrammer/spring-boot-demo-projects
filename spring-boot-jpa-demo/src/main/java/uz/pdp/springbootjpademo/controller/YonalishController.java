package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.StudentsDto;
import uz.pdp.springbootjpademo.payload.YonalishDto;
import uz.pdp.springbootjpademo.service.StudentsService;
import uz.pdp.springbootjpademo.service.YonalishService;

@RestController
@RequestMapping("/api/yonalish")
public class YonalishController {
    @Autowired
    YonalishService yonalishService;

    @PostMapping("/saveOrEditYonalish")
    public HttpEntity<?> saveOrEditDistrict(@RequestBody YonalishDto yonalishDto) {
        ApiResponse apiResponse = yonalishService.saveOrEditYonalish(yonalishDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteYonalish/{id}")
    public HttpEntity<?> removeGroups(@PathVariable(value = "id") Integer id){
        ApiResponse apiResponse =yonalishService.deleteYonalish(id);
        return ResponseEntity
                .status(apiResponse.isSuccess()  ?200 : 409)
                .body(apiResponse);
    }
}
