package uz.pdp.springbootloggingfilejaversresourseboundledemo.service;

import org.springframework.stereotype.Service;

import static uz.pdp.springbootloggingfilejaversresourseboundledemo.component.LocaleComponent.toLocale;

@Service
public class LocaleService {

    public String getTranslation(String str){
        return toLocale(str);
    }

}
