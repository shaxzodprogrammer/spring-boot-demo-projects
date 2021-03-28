package uz.pdp.springbootsecurityhometask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecurityhometask.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsernameOrPhoneNumberOrEmail(String username, String phoneNumber, String email);
}
