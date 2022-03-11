package com.example.print.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

        System.out.println(1000*60*60);
    }
}
