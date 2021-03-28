package uz.pdp.springbootsecurityhometask.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private String username;
    private String fullName;
    private String email;
    private String phoneNumber;

//    private List<RoleName> rolesNames;
}
