package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Courses;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.CoursesDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.YonalishRepository;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    YonalishRepository yonalishRepository;

    public ApiResponse saveOrEditDistrict(CoursesDto dto) {

        try {
            Courses courses = new Courses();
            if (dto.getId()!=null){
                courses = coursesRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("Student with this id not fount"));
            }
            courses.setName(dto.getName());
            coursesRepository.save(courses);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
    public ApiResponse deleteCourses(Integer id) {
        try {
            coursesRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
