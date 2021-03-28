//package uz.pdp.springbootjpademo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import uz.pdp.springbootjpademo.entity.District;
//import uz.pdp.springbootjpademo.entity.Region;
//import uz.pdp.springbootjpademo.payload.ApiResponse;
//import uz.pdp.springbootjpademo.payload.DistrictDto;
//import uz.pdp.springbootjpademo.payload.RegionDto;
//import uz.pdp.springbootjpademo.repository.DistrictRepository;
//import uz.pdp.springbootjpademo.repository.RegionRepository;
//
//@Service
//public class DistrictService {
//    @Autowired
//    DistrictRepository districtRepository;
//
//    @Autowired
//    RegionRepository regionRepository;
//
//    public ApiResponse saveOrEditDistrict(DistrictDto dto) {
//
//        try {
//            District district = new District();
//            if (dto.getId() != null) {
//                district = districtRepository.findById(dto.getId()).orElseThrow(()
//                        -> new IllegalStateException("District with this id no found"));
//            }
//            if(dto.getRegionId()!= null){
//                district.setRegion(regionRepository.findById(dto.getRegionId()).orElseThrow(
//                        ()-> new IllegalStateException("Region with this id no found")));
//            }
//            district.setName(dto.getName());
//            districtRepository.save(district);
//            return new ApiResponse(dto.getId() != null ? "Edited" : "Saved", true);
//        } catch (Exception e) {
//            return new ApiResponse("Eror", false);
//        }
//    }
//
//    public ApiResponse deleteDistrict(Integer id) {
//        try {
//            districtRepository.deleteById(id);
//            return new ApiResponse("Deleted", true);
//        } catch (Exception e) {
//            return new ApiResponse("Eror", false);
//        }
//    }
//}
