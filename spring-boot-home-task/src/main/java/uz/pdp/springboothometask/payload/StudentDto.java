package uz.pdp.springboothometask.payload;

import lombok.Data;

@Data
public class StudentDto {
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
