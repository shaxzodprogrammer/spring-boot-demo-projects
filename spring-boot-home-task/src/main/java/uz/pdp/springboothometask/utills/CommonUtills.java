package uz.pdp.springboothometask.utills;

import java.util.Base64;
import java.util.Random;

public class CommonUtills {

    public static int genereateCode(){
        return new Random().nextInt(900) + 100;
    }

    public static boolean ConfirmPassword(String password, String prePassword){
        return password.equals(prePassword);

    }

    public static String Encode(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
    public static String Decode(String password){
        return new String(Base64.getDecoder().decode(password));
    }
}
