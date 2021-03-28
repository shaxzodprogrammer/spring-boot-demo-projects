package uz.pdp.springbootsecuritytestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecuritytestdemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
