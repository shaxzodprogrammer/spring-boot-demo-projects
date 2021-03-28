package uz.pdp.springbootloggingfilejaversresourseboundledemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.repo.UserRepo;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.security.JwtTokenProvider;

import java.util.UUID;


@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;


    public UserDetails loadUserByUserId(String userIdFromToken) {
        return userRepository.findById(UUID.fromString(userIdFromToken)).orElseThrow(() -> new UsernameNotFoundException(userIdFromToken));
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException(phoneNumber));
    }

}
