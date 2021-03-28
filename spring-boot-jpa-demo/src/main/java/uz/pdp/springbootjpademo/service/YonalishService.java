package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Students;
import uz.pdp.springbootjpademo.entity.Yonalish;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.StudentsDto;
import uz.pdp.springbootjpademo.payload.YonalishDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.StudentsRepository;
import uz.pdp.springbootjpademo.repository.YonalishRepository;

@Service
public class YonalishService {
    @Autowired
    YonalishRepository yonalishRepository;
    @Autowired
    CoursesRepository coursesRepository;

    public ApiResponse saveOrEditYonalish(YonalishDto dto) {

        try {
          Yonalish yonalish = new Yonalish();
            if (dto.getId()!=null){
                yonalish = yonalishRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("Yonalish with this id not fount"));
            }
            yonalish.setName(dto.getName());
           yonalishRepository.save(yonalish);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
    public ApiResponse deleteYonalish(Integer id) {
        try {
            yonalishRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
