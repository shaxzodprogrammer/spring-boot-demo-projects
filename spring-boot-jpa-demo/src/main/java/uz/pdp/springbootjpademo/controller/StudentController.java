//package uz.pdp.springbootjpademo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import uz.pdp.springbootjpademo.payload.ApiResponse;
//import uz.pdp.springbootjpademo.payload.StudentDto;
//import uz.pdp.springbootjpademo.service.StudentService;
//import uz.pdp.springbootjpademo.utills.ApplicationConstanst;
//
//@RestController
//@RequestMapping("/api/student")
//public class StudentController {
//
//    @Autowired
//    StudentService studentService;
//
//    @PostMapping("/saveOrEdit")
//    public HttpEntity<?> saveOrEditStudent(@RequestBody StudentDto dto){
//        ApiResponse apiResponse = studentService.saveOrEditStudent(dto);
//        return ResponseEntity.status(apiResponse.isSuccess()?
//                apiResponse.getMessage().equals("Saved")?201:202: 409)
//                .body(apiResponse);
//    }
//
//    @GetMapping("/getAllStudents")
//    public HttpEntity<?> getAllStudents(@RequestParam(value = "page",
//                                              defaultValue = ApplicationConstanst.DEFAULT_PAGE_NUMBER)Integer page,
//                                        @RequestParam(value = "size",
//                                                defaultValue = ApplicationConstanst.DEFAULT_PAGE_SIZE)Integer size
//                                        ){
//        return ResponseEntity.ok(studentService.getAllStudents(page,size));
//    }
//
//    @GetMapping("/byId/{id}")
//    public HttpEntity<?> getOneStudentById(@PathVariable(value = "id") Integer id){
//        ApiResponse response = studentService.getOneStudentById(id);
//        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public HttpEntity<?> removeStudentById(@PathVariable("id") Integer id){
//        ApiResponse response = studentService.removeById(id);
//        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
//    }
//}
