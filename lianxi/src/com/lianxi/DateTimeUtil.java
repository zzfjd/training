package com.lianxi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
 
public class DateTimeUtil {
	
	public static String formatCSTDate(String cstDateStr) {
        Date date = null;
        SimpleDateFormat sdf1 = null;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date = sdf1.parse(cstDateStr);
        } catch (ParseException e) {
            sdf1 = new SimpleDateFormat("yyyy'年' MM'月' dd'日' EEE HH:mm:ss Z", Locale.CHINA);
            try {
                date = sdf1.parse(cstDateStr);
            } catch (ParseException e1) {
                System.out.println("CST日期格式转换出错，原因：" + e.getMessage());
                return null;
            }
        }
        
        return sdf2.format(date);
    }
    
    public static void main(String[] args) throws Exception {
        String str1 = "Wed JUL 19 05:31:00 CST 2017";
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        System.out.println(sdf1.parse(str1).toString());
    }
 
}

