package com.example.print.test;

import com.example.print.bean.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<User> list = Stream.of(new User(), new User(), new User()).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if(i==0) {
                list.get(i).setAge(111);
            }
        }
        System.out.println(list);
    }

    public  static  String change32To10(String num) {
        int f=32;
        int t=10;
        return new java.math.BigInteger(num, f).toString(t);
    }
}
