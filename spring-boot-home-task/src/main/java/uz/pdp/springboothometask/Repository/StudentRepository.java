package uz.pdp.springboothometask.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboothometask.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmailAndCode(String email, int code);
}