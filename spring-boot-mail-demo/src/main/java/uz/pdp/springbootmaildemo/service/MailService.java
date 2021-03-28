package uz.pdp.springbootmaildemo.service;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import uz.pdp.springbootmaildemo.payload.ApiResponse;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {


    @Autowired
    JavaMailSender sender;

    @Autowired
    Configuration configuration;

    public ApiResponse sentText(String sendToEmail){
       try {
           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
           simpleMailMessage.setText("This message was send like an  Aplicattion test");
           simpleMailMessage.setTo(sendToEmail);
           simpleMailMessage.setSubject("Hello!!");
           sender.send(simpleMailMessage);
           return new ApiResponse("Ok", true);
       }catch (Exception e){
           e.printStackTrace();
           return new ApiResponse("Eror", false);
       }
    }

    public ApiResponse sentHtml(String email) {
        try {
            Map<String,Object> model=new HashMap<>();
            model.put("email","shaxzod.programmer@gmail.com");
            model.put("fullName","Axmedov Shaxzod");
            model.put("code","8796");
            model.put("phoneNumber","+998949274363");
            MimeMessage mimeMessage=sender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper
                    (mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template template=configuration.getTemplate("email-template.ftl");
            String html= FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setTo(email);
            helper.setSubject("There is i send HTML page to email.");
            helper.setText(html,true);
            sender.send(mimeMessage);

            return new ApiResponse("Ok", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Eror", false);
        }
    }

    public ApiResponse sendFile(String email) {
        try {
            MimeMessage mimeMessage=sender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(email);
            helper.setSubject("SpringBootApplication");
            helper.setText("Assalomu alaykum. Bu Spring boot applicationidan jonatilgan  file ");
            String name="osh.jpg";
            File file = ResourceUtils.getFile("src/main/resources/static/appFiles/"+name);
            InputStream in = new FileInputStream(file);
            byte[] bdata = FileCopyUtils.copyToByteArray(in);
            ByteArrayDataSource attachment = new ByteArrayDataSource(bdata, "application/octet-stream");
            helper.addAttachment(name,attachment);
            Thread thread = new Thread(){
                public void run(){
                    sender.send(mimeMessage);
                }
            };
            thread.start();
            return new ApiResponse("Sended",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
}
