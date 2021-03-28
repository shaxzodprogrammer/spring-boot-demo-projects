package uz.pdp.springbootsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.springbootsecuritydemo.entiry.User;
import uz.pdp.springbootsecuritydemo.payload.ApiResponse;
import uz.pdp.springbootsecuritydemo.payload.UserDto;
import uz.pdp.springbootsecuritydemo.repository.RoleRepository;
import uz.pdp.springbootsecuritydemo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse register(UserDto userDto){
        try {
            User user =new User();
            user.setFullName(userDto.getFullName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setRoles(roleRepository.findAllByRoleNameIn(userDto.getRoleNames()));
            userRepository.save(user);
            return new ApiResponse("Ok",true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error",false);
        }
    }

}
