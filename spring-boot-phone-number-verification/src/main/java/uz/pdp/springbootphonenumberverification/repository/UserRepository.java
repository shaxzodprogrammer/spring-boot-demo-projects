package uz.pdp.springbootphonenumberverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootphonenumberverification.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository< User,Integer> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
