package uz.pdp.springbootjpademo.payload;


import lombok.Data;

@Data
public class MentorsDto {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
}
