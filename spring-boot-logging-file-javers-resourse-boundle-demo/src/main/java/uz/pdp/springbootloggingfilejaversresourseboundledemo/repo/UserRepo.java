package uz.pdp.springbootloggingfilejaversresourseboundledemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
