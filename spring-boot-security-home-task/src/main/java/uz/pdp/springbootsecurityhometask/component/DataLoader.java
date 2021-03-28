package uz.pdp.springbootsecurityhometask.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.springbootsecurityhometask.entity.Book;
import uz.pdp.springbootsecurityhometask.entity.Role;
import uz.pdp.springbootsecurityhometask.entity.User;
import uz.pdp.springbootsecurityhometask.entity.enums.RoleNames;
import uz.pdp.springbootsecurityhometask.repository.BookRepository;
import uz.pdp.springbootsecurityhometask.repository.RoleRepository;
import uz.pdp.springbootsecurityhometask.repository.UserRepository;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String mode;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role superAdmin = roleRepository.save(new Role(RoleNames.ROLE_SUPER_ADMIN));
            Role admin = roleRepository.save(new Role(RoleNames.ROLE_ADMIN));
            Role moderator = roleRepository.save(new Role(RoleNames.ROLE_MODERATOR));
            Role client = roleRepository.save(new Role(RoleNames.ROLE_CLIENT));

            userRepository.save(new User("superAdmin", passwordEncoder.encode("superAdmin"),
                    "superAdmin", "+999"
                    ,"superAdminEmail@gmail.com", Collections.singletonList(superAdmin)));

            userRepository.save(new User("admin",passwordEncoder.encode("admin"),"admin",
                     "+888"
                    ,"adminEmail@gmail.com", Collections.singletonList(admin)));

            userRepository.save(new User("moder","moder", passwordEncoder.encode("moder"),
                     "+777"
                    ,"moderEmail@gmail.com", Collections.singletonList(moderator)));

            userRepository.save(new User("client", "client",passwordEncoder.encode("client"),
                     "+666"
                    ,"clientEmail@gmail.com", Collections.singletonList(client)));

            bookRepository.save(new Book("O'tgan kunlar", "Abdulla Qodiriy"));

        }
    }
}
