package uz.pdp.springbootsecuritydemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.springbootsecuritydemo.entiry.Role;
import uz.pdp.springbootsecuritydemo.entiry.User;
import uz.pdp.springbootsecuritydemo.entiry.enums.RoleName;
import uz.pdp.springbootsecuritydemo.repository.RoleRepository;
import uz.pdp.springbootsecuritydemo.repository.UserRepository;
import uz.pdp.springbootsecuritydemo.service.UserService;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            Role superAdmin = roleRepository.save(new Role(RoleName.ROLE_SUPER_ADMIN));
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            roleRepository.save(new Role(RoleName.ROLE_CLIENT));
            roleRepository.save(new Role(RoleName.ROLE_MODERATOR));
            User user =new User();
            user.setFullName("SuperAdmin");
            user.setPhoneNumber("+998993632587");
            user.setEmail("test@gmail.com");
            user.setUsername("superAdmin");
            user.setPassword(passwordEncoder.encode("root123"));
            user.setRoles(Collections.singletonList(superAdmin));
            userRepository.save(user);
        }
    }
}
