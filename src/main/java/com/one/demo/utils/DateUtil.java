package com.one.demo.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    static DateTimeFormatter  timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getNow(){
        return LocalDateTime.now().format(timeFormatter);
    }

}
