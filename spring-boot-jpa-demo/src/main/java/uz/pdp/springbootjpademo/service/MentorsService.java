package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.LearningCenter;
import uz.pdp.springbootjpademo.entity.Mentors;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.CoursesDto;
import uz.pdp.springbootjpademo.payload.MentorsDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.LearningCenterRepository;
import uz.pdp.springbootjpademo.repository.MentorsRepository;

@Service
public class MentorsService {
    @Autowired
    MentorsRepository mentorsRepository;
    @Autowired
    CoursesRepository coursesRepository;

    public ApiResponse saveOrEditMentors(MentorsDto dto) {

        try {
           Mentors mentors = new Mentors();
            if (dto.getId()!=null){
                mentors = mentorsRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("Mentors with this id not fount"));
            }
            mentors.setName(dto.getName());
            mentors.setEmail(dto.getEmail());
            mentors.setPhoneNumber(dto.getPhoneNumber());
            mentorsRepository.save(mentors);
            return new ApiResponse(dto.getId()!=null?"Edited":"Saved",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
    public ApiResponse deleteMentors(Integer id) {
        try {
            mentorsRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
