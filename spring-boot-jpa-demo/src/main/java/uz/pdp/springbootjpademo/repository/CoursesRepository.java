package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}