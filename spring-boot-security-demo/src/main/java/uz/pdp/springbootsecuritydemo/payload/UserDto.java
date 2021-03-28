package uz.pdp.springbootsecuritydemo.payload;

import lombok.Data;
import uz.pdp.springbootsecuritydemo.entiry.enums.RoleName;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String username;
    private List<RoleName> roleNames;
}
