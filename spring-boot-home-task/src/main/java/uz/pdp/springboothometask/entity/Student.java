package uz.pdp.springboothometask.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is false")
@SQLDelete(sql = "update student set deleted=true where id=?")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private String nickName;


    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number must be 13 digits.")
    @Column(unique = true)
    private String phoneNumber;

    private String password;

    private int code;

    //    @Column(name = "enable", columnDefinition = "BOOLEAN DEAFULT false")
    private boolean enable;


    //    @Column(name = "deleted", columnDefinition="BOOLEAN DEFAULT false")
    private boolean deleted;


}
