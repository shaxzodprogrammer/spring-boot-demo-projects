package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpademo.entity.LearningCenter;

public interface LearningCenterRepository extends JpaRepository<LearningCenter, Integer> {
}