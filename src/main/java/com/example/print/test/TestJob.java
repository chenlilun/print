package com.example.print.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class TestJob {
//    @Scheduled(cron = "* 0/2 * * * *")
    public void test() {
        String silkCode = "abcdefg";
        StringBuilder sb = new StringBuilder() ;
        sb.replace(silkCode.length()-2,silkCode.length()-1, "") ;
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(1000*60*60);
        System.out.println(int2chineseNum(10));
    }

    public static String int2chineseNum(int src) {
        final String num[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String unit[] = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String dst = "";
        int count = 0;
        while(src > 0) {
            dst = (num[src % 10] + unit[count]) + dst;
            src = src / 10;
            count++;
        }
        return dst.replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
    }
}
