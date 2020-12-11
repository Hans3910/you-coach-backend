package com.switchfully.youcoach.util;

import java.time.format.DateTimeFormatter;

public class FormatUtil {

    public static DateTimeFormatter getDateFormat(){
        return DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static DateTimeFormatter getTimeFormat(){
        return DateTimeFormatter.ofPattern("HH:mm");
    }
}
