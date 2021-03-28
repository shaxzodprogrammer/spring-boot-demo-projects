package uz.pdp.springbootloggingfilejaversresourseboundledemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleComponent {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public LocaleComponent(@Qualifier("messages") ResourceBundleMessageSource messageSource){
        this.messageSource=messageSource;
    }

    public static String toLocale(String code){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code,null,locale);
    }

}
