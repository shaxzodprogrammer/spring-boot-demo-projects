package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Courses;
import uz.pdp.springbootjpademo.entity.LearningCenter;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.CoursesDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.LearningCenterRepository;
import uz.pdp.springbootjpademo.repository.YonalishRepository;

@Service
public class LearningCenterService {
    @Autowired
    LearningCenterRepository learningCenterRepository;
    @Autowired
    CoursesRepository coursesRepository;

    public ApiResponse saveOrEditLearningCenter(CoursesDto dto) {

        try {
            LearningCenter learningCenter = new LearningCenter();
            if (dto.getId()!=null){
                learningCenter = learningCenterRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("LearningCenter with this id not fount"));
            }
            learningCenter.setName(dto.getName());
            learningCenterRepository.save(learningCenter);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
    public ApiResponse deleteLearningCenter(Integer id) {
        try {
            learningCenterRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
