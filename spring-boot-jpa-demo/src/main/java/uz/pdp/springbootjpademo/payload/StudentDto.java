package uz.pdp.springbootjpademo.payload;

import lombok.Data;

@Data
public class StudentDto {
    private Integer id;
    private String name,email,phoneNumber;
}
