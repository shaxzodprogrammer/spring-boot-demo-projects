package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.Mentors;

public interface MentorsRepository extends JpaRepository<Mentors, Integer> {
}