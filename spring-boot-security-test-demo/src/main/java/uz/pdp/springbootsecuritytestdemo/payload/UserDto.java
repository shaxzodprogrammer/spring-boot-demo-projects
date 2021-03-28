package uz.pdp.springbootsecuritytestdemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String login;
    private String fullName;
    private String password;
    private String username;
    private String phoneNumber;
    private String email;
}
