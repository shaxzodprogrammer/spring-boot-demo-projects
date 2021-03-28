package uz.pdp.springbootsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springbootsecuritydemo.entiry.User;
import uz.pdp.springbootsecuritydemo.entiry.enums.RoleName;
import uz.pdp.springbootsecuritydemo.jwt.JwtTokenProvider;
import uz.pdp.springbootsecuritydemo.payload.ApiResponse;
import uz.pdp.springbootsecuritydemo.payload.JwtResponse;
import uz.pdp.springbootsecuritydemo.payload.UserDto;
import uz.pdp.springbootsecuritydemo.service.AuthService;
import uz.pdp.springbootsecuritydemo.service.UserService;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("/registerAdmin")
    public HttpEntity<?> registerAdmin(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.register(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }


    @PostMapping("/registerClient")
    public HttpEntity<?> registerClient(@RequestBody UserDto userDto) {
        userDto.setRoleNames(Collections.singletonList(RoleName.ROLE_CLIENT));
        ApiResponse apiResponse = userService.register(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User principal = (User) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
