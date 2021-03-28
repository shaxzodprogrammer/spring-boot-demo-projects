package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Mentors;
import uz.pdp.springbootjpademo.entity.Students;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.MentorsDto;
import uz.pdp.springbootjpademo.payload.StudentsDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.MentorsRepository;
import uz.pdp.springbootjpademo.repository.StudentsRepository;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    CoursesRepository coursesRepository;

    public ApiResponse saveOrEditStudents(StudentsDto dto) {

        try {
          Students students = new Students();
            if (dto.getId()!=null){
                students = studentsRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("Students with this id not fount"));
            }
            students.setName(dto.getName());
            students.setEmail(dto.getEmail());
            students.setPhoneNumber(dto.getPhoneNumber());
           studentsRepository.save(students);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
    public ApiResponse deleteStudents(Integer id) {
        try {
            studentsRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
