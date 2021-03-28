package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.Groups;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {
}