package uz.pdp.springboothometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboothometask.payload.ApiResponse;
import uz.pdp.springboothometask.payload.StudentDto;
import uz.pdp.springboothometask.service.AuthService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody StudentDto studentDto) {
        ApiResponse apiResponse =authService.register(studentDto);
        return ResponseEntity
                .status(apiResponse.isSuccess()?201:409)
                .body(apiResponse);
    }

    @GetMapping("/confirm")
    public HttpEntity<?> confirm(@RequestParam String email, @RequestParam Integer code){
        ApiResponse apiResponse = authService.confirm(email,code);
        return ResponseEntity
                .status(apiResponse.isSuccess()?200:409)
                .body(apiResponse);
    }
    @GetMapping("/cancel")
    public HttpEntity<?> cancel(@RequestParam String email, @RequestParam Integer code){
        ApiResponse apiResponse = authService.cancel(email,code);
        return ResponseEntity
                .status(apiResponse.isSuccess()?200:409)
                .body(apiResponse);
    }
}
