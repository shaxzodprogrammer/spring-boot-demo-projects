package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Region;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.RegionDto;
import uz.pdp.springbootjpademo.repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    public ApiResponse saveOrEditRegion(RegionDto dto) {

 try {
     Region region = new Region();
     if (dto.getId() != null){
         region = regionRepository.findById(dto.getId()).orElseThrow(()
                 -> new IllegalStateException("Region with this id no found"));
     }
     region.setName(dto.getName());
     regionRepository.save(region);
     return new ApiResponse(dto.getId()!=null?"Edited":"Saved", true);
 }catch (Exception e){
     return new ApiResponse("Eror", false);
 }
    }

    public ApiResponse deleteRegion(Integer id){
        try{
            regionRepository.deleteById(id);
            return  new ApiResponse("Deleted", true);
        }catch (Exception e){
            return new ApiResponse("Eror", false);
        }
    }
}
