package uz.pdp.springbootsecurityhometask.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Where(clause = "deleted is false")
//@SQLDelete(sql = "update student set deleted=true where id=?")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}


