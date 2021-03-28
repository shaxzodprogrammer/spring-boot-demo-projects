package uz.pdp.springbootsecuritydemo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/second")
public class SecondController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_CLIENT')")
    public HttpEntity<?> firstGetMethod(){
        return ResponseEntity.ok("This is from second controller.");
    }
}
