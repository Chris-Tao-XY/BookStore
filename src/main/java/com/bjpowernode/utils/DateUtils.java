package com.bjpowernode.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getWSysDateTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date=new Date();
        return simpleDateFormat.format(date);
    }

}
