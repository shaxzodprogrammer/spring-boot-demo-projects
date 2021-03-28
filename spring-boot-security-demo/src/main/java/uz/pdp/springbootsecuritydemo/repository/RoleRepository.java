package uz.pdp.springbootsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecuritydemo.entiry.Role;
import uz.pdp.springbootsecuritydemo.entiry.enums.RoleName;

import java.util.Collection;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findAllByRoleNameIn(Collection<RoleName> roleName);
    Role findByRoleName(RoleName roleName);
}
