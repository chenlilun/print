package com.example.print.utils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String addDateMinut(String day, int hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return format.format(date);

    }

    public static String reduceEight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, -8);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        String format1 = format.format(cal.getTime());
        return format1;
    }

    public static String reduceEightBefore(Date date,String lineName) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, -8);
        return getProductClass(cal.getTime());
    }
    public static String getProductClass(Date createDate) {
        //距离1970年1月1号天数三十二进制
        //7点50前日期为前一日，后为当天
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
//        String format1 = format.format(cal.getTime());

        Calendar c = Calendar.getInstance();
        c.setTime(createDate);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        if (hour < 7 || (hour == 7 && minute < 50)) {
            c.add(Calendar.DAY_OF_MONTH, -1);
            createDate.setTime(c.getTime().getTime());

        }
        String format1 = format.format(createDate.getTime());
        return format1;
    }
    public static void main(String[] args) {
        System.out.println(addDateMinut("2020-10-18T10:28:00.034+00:00", 2));
    }
}
