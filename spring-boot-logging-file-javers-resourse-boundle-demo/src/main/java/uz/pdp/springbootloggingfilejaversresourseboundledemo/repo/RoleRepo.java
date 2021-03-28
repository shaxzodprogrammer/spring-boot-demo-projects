package uz.pdp.springbootloggingfilejaversresourseboundledemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.entity.Role;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.entity.User;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
