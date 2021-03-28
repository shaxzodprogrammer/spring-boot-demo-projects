package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}