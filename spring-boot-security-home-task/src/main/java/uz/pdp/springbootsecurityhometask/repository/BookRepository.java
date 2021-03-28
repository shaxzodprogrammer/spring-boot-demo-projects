package uz.pdp.springbootsecurityhometask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootsecurityhometask.entity.Book;
import uz.pdp.springbootsecurityhometask.entity.Role;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
