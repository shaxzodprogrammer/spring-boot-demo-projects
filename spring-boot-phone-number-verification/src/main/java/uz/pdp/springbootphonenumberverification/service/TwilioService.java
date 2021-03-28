package uz.pdp.springbootphonenumberverification.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.pdp.springbootphonenumberverification.entity.TwilioVerification;
import uz.pdp.springbootphonenumberverification.payload.ApiResponse;
import uz.pdp.springbootphonenumberverification.repository.TwilioVerificationRepository;
import uz.pdp.springbootphonenumberverification.repository.UserRepository;
import uz.pdp.springbootphonenumberverification.utils.CommonUtils;

import java.util.Optional;

@Service
public class TwilioService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TwilioVerificationRepository twilioVerificationRepository;

    @Value("${twilio.phone}")
    private String twilioPhone;

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.token}")
    private String twilioToken;

    public ApiResponse sendCode(String phoneNumber){

        try {

            int code = CommonUtils.generateCode();

            phoneNumber = phoneNumber.startsWith("+")?phoneNumber:"+" + phoneNumber;
            phoneNumber = phoneNumber.replace(" ", "");
            Twilio.init(twilioSid, twilioToken);
            Message message = Message.creator(
                    new PhoneNumber(phoneNumber),
                    new PhoneNumber(twilioPhone),
                    "Hi there! It`s your code from twilio trail: " + code)
                    .create();
            Optional<TwilioVerification> optional = twilioVerificationRepository
                    .findByPhoneNumberAndVerifiedFalse(phoneNumber);
            if (optional.isPresent()){
                TwilioVerification twilioVerification = optional.get();
                twilioVerification.setCode(code);
                twilioVerification.setVerified(false);
                twilioVerificationRepository.save(twilioVerification);
            }else {
                TwilioVerification twilioVerification = new TwilioVerification();
                twilioVerification.setPhoneNumber(phoneNumber);
                twilioVerification.setCode(code);
                twilioVerification.setVerified(false);
                twilioVerificationRepository.save(twilioVerification);
            }
            return new ApiResponse("Code successfuly sended", true, code);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Code not sended", false);
        }
    }

    public ApiResponse verify(String phoneNumber, int code){
        phoneNumber = phoneNumber.startsWith("+")?phoneNumber:"+" + phoneNumber;
        phoneNumber = phoneNumber.replace(" ", "");
        Twilio.init(twilioSid,twilioToken);
        Optional<TwilioVerification> optional = twilioVerificationRepository
                .findByPhoneNumberAndVerifiedFalse(phoneNumber);
        if (optional.isPresent()){
            TwilioVerification twilioVerification = optional.get();
            if (twilioVerification.getCode() == code){
                twilioVerification.setVerified(true);
                twilioVerificationRepository.save(twilioVerification);
                return new ApiResponse("Success", true);
            }else {
                return new ApiResponse("Eror code", false);
            }
        }else {
            return new ApiResponse("Eror phone number", false);
        }
    }
}
