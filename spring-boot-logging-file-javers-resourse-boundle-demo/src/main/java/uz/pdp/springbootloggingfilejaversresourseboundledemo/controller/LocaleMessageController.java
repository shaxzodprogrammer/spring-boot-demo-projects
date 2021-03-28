package uz.pdp.springbootloggingfilejaversresourseboundledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.service.LocaleService;

@RestController
@RequestMapping("/api/localeMessage")
public class LocaleMessageController {

    @Autowired
    LocaleService localeService;

    @GetMapping("/{resourseName}")
    public HttpEntity<?> localeMessage(@PathVariable String resourseName){
        return ResponseEntity.ok(localeService.getTranslation(resourseName));
    }
}
