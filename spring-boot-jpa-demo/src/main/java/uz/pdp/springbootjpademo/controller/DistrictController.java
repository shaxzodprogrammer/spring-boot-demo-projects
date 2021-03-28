//package uz.pdp.springbootjpademo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import uz.pdp.springbootjpademo.payload.ApiResponse;
//import uz.pdp.springbootjpademo.payload.DistrictDto;
//import uz.pdp.springbootjpademo.service.DistrictService;
//
//@RestController
//@RequestMapping("/api/district")
//public class DistrictController {
//    @Autowired
//    DistrictService districtService;
//
//    @PostMapping("/saveOrEditDistrict")
//    public HttpEntity<?> saveOrEditDistrict(@RequestBody DistrictDto districtDto) {
//        ApiResponse apiResponse = districtService.saveOrEditDistrict(districtDto);
//        return ResponseEntity
//                .status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
//                .body(apiResponse);
//    }
//
//    @DeleteMapping("/deleteDistrict/{id}")
//    public HttpEntity<?> removeDistrict(@PathVariable(value = "id") Integer id){
//        ApiResponse apiResponse = districtService.deleteDistrict(id);
//        return ResponseEntity
//                .status(apiResponse.isSuccess()  ?200 : 409)
//                .body(apiResponse);
//    }
//}
