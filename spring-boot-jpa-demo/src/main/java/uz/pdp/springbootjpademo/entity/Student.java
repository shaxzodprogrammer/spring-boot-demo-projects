//package uz.pdp.springbootjpademo.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Pattern;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Where(clause = "deleted is false")
//@SQLDelete(sql="update student set deleted=true where id=?")
//@Entity
//public class Student extends AbsNameEntity {
//
//
//    @Email
//    @Column(nullable = false)
//    private String email;
//
//    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number must be 13 digits.")
//    private String phoneNumber;
//
////    @Column(name = "deleted", columnDefinition="BOOLEAN DEFAULT false")
////    private boolean deleted;
//
//    @ManyToMany
//    private List<Course> courses;
//}
