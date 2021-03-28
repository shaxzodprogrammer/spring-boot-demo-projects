package uz.pdp.springbootsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootsecuritydemo.entiry.User;
import uz.pdp.springbootsecuritydemo.payload.ApiResponse;
import uz.pdp.springbootsecuritydemo.payload.UserDto;
import uz.pdp.springbootsecuritydemo.repository.UserRepository;

import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    public User loadUserByUserId(String userIdFromToken) {
        return userRepository.findById(UUID.fromString(userIdFromToken)).orElseThrow(() -> new IllegalStateException("User not found"));
    }
}
