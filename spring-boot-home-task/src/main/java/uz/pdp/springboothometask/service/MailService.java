package uz.pdp.springboothometask.service;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import uz.pdp.springboothometask.payload.ApiResponse;
import uz.pdp.springboothometask.payload.StudentDto;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {

    private static JavaMailSender sender;

    private static Configuration configuration;

    @Autowired
    public MailService(JavaMailSender sender, Configuration configuration) {
        this.sender = sender;
        this.configuration = configuration;
    }

    public boolean sentHtml(int code, StudentDto dto) {
        try {
            Map<String,Object> model=new HashMap<>();
            model.put("fullName",dto.getFirstName() + " " + dto.getLastName());
            model.put("code",code);
            model.put("email",dto.getEmail());
            model.put("phoneNumber",dto.getPhoneNumber());
            MimeMessage mimeMessage=sender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper
                    (mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template template=configuration.getTemplate("email-template.ftl");
            String html= FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setTo(dto.getEmail());
            helper.setSubject("There is i send HTML page to email.");
            helper.setText(html,true);
            sender.send(mimeMessage);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
