package uz.pdp.springbootjpademo.service;

import com.sun.prism.GraphicsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Courses;
import uz.pdp.springbootjpademo.entity.Groups;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.CoursesDto;
import uz.pdp.springbootjpademo.payload.GroupsDto;
import uz.pdp.springbootjpademo.repository.CoursesRepository;
import uz.pdp.springbootjpademo.repository.GroupsRepository;
import uz.pdp.springbootjpademo.repository.StudentsRepository;
import uz.pdp.springbootjpademo.repository.YonalishRepository;

@Service
public class GroupsService {
    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    StudentsRepository studentsRepository;

    public ApiResponse saveOrEditGroups(GroupsDto dto) {

        try {
            Groups groups = new Groups();
            if (dto.getId() != null) {
               groups = groupsRepository.findById(dto.getId())
                        .orElseThrow(() -> new IllegalStateException("Group with this id not fount"));
            }
            groups.setName(dto.getName());
           groupsRepository.save(groups);
            return new ApiResponse(dto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse deleteGroups(Integer id) {
        try {
           groupsRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Eror", false);
        }
    }
}
