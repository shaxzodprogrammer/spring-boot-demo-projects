package uz.pdp.springbootsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecuritydemo.entiry.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
