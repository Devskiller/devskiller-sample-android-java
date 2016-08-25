package com.devskiller.calculator.calculator;


public class StringUtil {

    public static String removeLastChar(String str) {
        if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
}
