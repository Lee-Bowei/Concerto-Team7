package com.example.concerto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCode {
    /*
    正则匹配手机号码:
     */
    public static boolean checkTele(String tele){
        Pattern p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$");
        Matcher matcher = p.matcher(tele);
        return matcher.matches();
    }
}