package uz.pdp.springbootsecurityhometask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecurityhometask.entity.Role;
import uz.pdp.springbootsecurityhometask.entity.User;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
