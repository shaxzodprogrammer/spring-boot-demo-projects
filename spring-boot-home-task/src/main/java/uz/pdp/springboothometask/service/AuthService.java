package uz.pdp.springboothometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springboothometask.Repository.StudentRepository;
import uz.pdp.springboothometask.entity.Student;
import uz.pdp.springboothometask.payload.ApiResponse;
import uz.pdp.springboothometask.payload.StudentDto;
import uz.pdp.springboothometask.utills.CommonUtills;

@Service
public class AuthService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MailService mailService;


    public ApiResponse register(StudentDto dto) {

       try{
           if (CommonUtills.ConfirmPassword(dto.getPassword(), dto.getConfirmPassword())){
           int code = CommonUtills.genereateCode();

               Student student = new Student();

               student.setFirstName(dto.getFirstName());
               student.setLastName(dto.getLastName());
               student.setNickName(dto.getNickName());
               student.setPhoneNumber(dto.getPhoneNumber());
               student.setEmail(dto.getEmail());
               student.setPassword(CommonUtills.Encode((dto.getPassword())));
               student.setCode(code);
               if (mailService.sentHtml(code, dto)){
                   studentRepository.save(student);
                   return new ApiResponse("You are registered successfully, confirm your email",true);
               }else {
                   return new ApiResponse("Try again. Eror in sending email", false);
               }
           }else {
               return new ApiResponse("Eror confirm password", false);
           }
       }catch (Exception e){
           return new ApiResponse("Eror", false);

       }




    }
    public ApiResponse cancel(String email, Integer code) {
        try {
            Student student = studentRepository.findByEmailAndCode(email,code);
            studentRepository.delete(student);
            return new ApiResponse("Ok", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Eror" , false);
        }
    }

    public ApiResponse confirm(String email, Integer code) {
try {
  Student student = studentRepository.findByEmailAndCode(email,code);
  student.setEnable(true);
  studentRepository.save(student);
    return new ApiResponse("Ok", true);
}catch (Exception e){
    e.printStackTrace();
    return new ApiResponse("Eror" , false);
}
    }
}
