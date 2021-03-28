package uz.pdp.springbootphonenumberverification.utils;

import java.util.Random;

public class CommonUtils {

    public static int generateCode(){
        return new Random().nextInt( (999999 - 100000) + 1 ) + 100000;
    }
}
