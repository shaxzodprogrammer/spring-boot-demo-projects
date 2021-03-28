package uz.pdp.springbootloggingfilejaversresourseboundledemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.entity.Role;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.entity.User;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.repo.RoleRepo;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.repo.UserRepo;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Value("${spring.datasource.initialization-mode}")
    private String mode;


    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role roleAdmin = roleRepo.save(new Role("ROLE_ADMIN"));
            userRepo.save(new User("Admin","+123456",passwordEncoder.encode("root123"),roleAdmin));
        }
    }
}
