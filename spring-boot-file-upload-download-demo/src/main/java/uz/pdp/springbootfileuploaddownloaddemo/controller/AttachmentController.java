package uz.pdp.springbootfileuploaddownloaddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.springbootfileuploaddownloaddemo.payload.ApiResponse;
import uz.pdp.springbootfileuploaddownloaddemo.service.AttachmentService;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/dbSave")
    public HttpEntity<?> dbSave(MultipartHttpServletRequest request) {
        ApiResponse apiResponse = attachmentService.dbSave(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/serverSave")
    public HttpEntity<?> serverSaver(MultipartHttpServletRequest request){

        ApiResponse apiResponse = attachmentService.serverSave(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/fromDB/{id}")
    public HttpEntity<?> fromDB(@PathVariable UUID id) {
        return attachmentService.getFromDB(id);
    }

    @GetMapping("/fromServer/{id}")
    public HttpEntity<?> fromServer(@PathVariable UUID id) {
            return attachmentService.fromServer(id);
    }
}
