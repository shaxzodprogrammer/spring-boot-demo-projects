package uz.pdp.springbootsecuritydemo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/first")
public class FirstController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    public HttpEntity<?> secondGetMethod(){
        return ResponseEntity.ok("This is from first controller.");
    }

    @DeleteMapping
    public HttpEntity<?> postToFirst(){
        return ResponseEntity.ok("From Post Mapping");
    }
}
