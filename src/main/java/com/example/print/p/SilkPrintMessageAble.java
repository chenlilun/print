package com.example.print.p;


import com.example.print.service.DoffService;
import com.example.print.utils.FileUtils;
import com.example.print.utils.QRCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;

public class SilkPrintMessageAble implements Printable {
    private static List<SilkPrintMessage> silkPrintMessageList;
    private Logger logger = LoggerFactory.getLogger(SilkPrintMessageAble.class);
    public static void setSilkPrintMessageList(List<SilkPrintMessage> silkPrintMessageList){
        SilkPrintMessageAble.silkPrintMessageList=silkPrintMessageList;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
//        String team = FileUtils.readText("D:\\printService\\team.txt").replace("\n", "");

     /*   if(ObjectUtils.isEmpty(team)){
            team= ""   ;
        }else {
            team = getHanTeam(team) ;
        }*/

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.BLACK);//设置颜色
        //模式  字体   字体大小
        g2d.setFont(new Font("Default", Font.BOLD, 7));
        int startX1=3;//第一列初始x值
        int startX=2;//第一列初始x值
        int dValue1=71  ;//列差值
//        int startY1=6;//第一行初始Y值
        int startY1=6;//第一行初始Y值
//        int startY2=14;//第二行Y值
        int startY2=13;//第二行Y值

        int startX2=41;//第二列X值
        int startX2Y2=48;//第二列X值

//        int startY3=22;//第三列Y值
        int startY3=20;//第三列Y值
        int startY333=40;//第三列Y值
        int startY33=28;//第三列Y值
        int y1 = 27 ;
        int y2 = 34;
        int y3 = 42 ;
        int startX22=41;//第三行第二列
        int startX23=40;//第三行第三列
        int startXcode=5;//二维码x
//        int startYcode=25;//二维码Y
        int startYcode=23;//二维码Y
        int wh=33;//边长
        int startX4=3;
        int startX2Add=5;
//        int startY4=65;
        int startY4=61;
        for(int i=0;i<silkPrintMessageList.size();i++){

            SilkPrintMessage silkPrintMessage = silkPrintMessageList.get(i);
            String product = "";
            product = getHanTeam(silkPrintMessage.getCls()) ;
            if(!ObjectUtils.isEmpty(silkPrintMessage.getCls())){
                product = silkPrintMessage.getCls() ;
            }
              if(i==silkPrintMessageList.size()-1){
             /*     String code = silkPrintMessage.getSilkCarCode() ;
                  if(!ObjectUtils.isEmpty(code)){
                      g2d.drawString(code.substring(code.length()-3),startX1,y2);

                  }*/
              }

            if(i%4==0){
                composeAll(g2d, startX1, startX, dValue1, startY1, startY2, startX2, startX2Y2, startY3, startY333, startY33, startX23, startXcode, startYcode, wh, startX4, startX2Add, startY4, i, silkPrintMessage ,product);
            }else if(i%4==1){
                if(silkPrintMessage.getBlank()==null||!silkPrintMessage.getBlank()){
                    g2d.drawString(silkPrintMessage.getBatchNo(),startX1+(dValue1*i),startY1);
                    g2d.drawString(silkPrintMessage.getSpec(),startX1+(dValue1*i),startY2);
                    g2d.drawString(silkPrintMessage.getDoffDate()+"/"+silkPrintMessage.getDoffNo(),startX1+(dValue1*i),startY3);
                    g2d.drawString(product,startX23+(dValue1*i),startY333-10);
                    g2d.drawString(silkPrintMessage.getLineMachine(),startX23+(dValue1*i),startY333-3);
                    g2d.drawString(silkPrintMessage.getSpindleNum()+"",startX23+(dValue1*i),startY333+4);
                    g2d.drawString(setSpindleNum(silkPrintMessage),startX23+(dValue1*i),startY333+11);
                    g2d.drawImage(QRCodeUtil.getImage(silkPrintMessage.getQrCode()),startXcode+(dValue1*i),startYcode,wh,wh,null);
                    g2d.drawString(silkPrintMessage.getQrCode(),startX4+(dValue1*i),startY4);
                }else {
                    String code = silkPrintMessage.getSilkCarCode() ;
                    if(!ObjectUtils.isEmpty(code)){
                        g2d.drawString(code.substring(code.length()-3),startX1+(dValue1*i),startY3);
                    }
                }
            }else if(i%4==2){
                composeAll(g2d, startX1, startX, dValue1, startY1, startY2, startX2, startX2Y2, startY3, startY333, startY33, startX23, startXcode, startYcode, wh, startX4, startX2Add, startY4, i, silkPrintMessage,product);
            }else{
                composeAll(g2d, startX1, startX, dValue1, startY1, startY2, startX2, startX2Y2, startY3, startY333, startY33, startX23, startXcode, startYcode, wh, startX4, startX2Add, startY4, i, silkPrintMessage,product);
            }
        }
       return 0;
    }

    private void composeAll(Graphics2D g2d, int startX1, int startX, int dValue1, int startY1, int startY2, int startX2, int startX2Y2, int startY3, int startY333, int startY33, int startX23, int startXcode, int startYcode, int wh, int startX4, int startX2Add, int startY4, int i, SilkPrintMessage silkPrintMessage,String product) {
        if(silkPrintMessage.getBlank()==null||!silkPrintMessage.getBlank()){
            g2d.drawString(silkPrintMessage.getBatchNo(),startX1+(dValue1*i),startY1);
            g2d.drawString(silkPrintMessage.getSpec(),startX1+(dValue1*i),startY2);
            g2d.drawString(silkPrintMessage.getDoffDate()+"/"+silkPrintMessage.getDoffNo(),startX1+(dValue1*i),startY3);
            g2d.drawString(product,startX23+(dValue1*i),startY333-10);  //产品
            g2d.drawString(silkPrintMessage.getLineMachine(),startX23+(dValue1*i),startY333-3);
            g2d.drawString(silkPrintMessage.getSpindleNum()+"",startX23+(dValue1*i),startY333+4);
            g2d.drawString(setSpindleNum(silkPrintMessage) ,startX23+(dValue1*i),startY333+11);
            g2d.drawImage(QRCodeUtil.getImage(silkPrintMessage.getQrCode()),startXcode+(dValue1*i),startYcode,wh,wh,null);
            g2d.drawString(silkPrintMessage.getQrCode(),startX4+(dValue1*i),startY4);
            if(!ObjectUtils.isEmpty(silkPrintMessage.getDoffDateBefore())){
                g2d.drawString(silkPrintMessage.getDoffDateBefore(),startX+(dValue1*i),startY33);
            }
        }else {
            String code = silkPrintMessage.getSilkCarCode() ;
            if(!ObjectUtils.isEmpty(code)){

            }
        }
    }

    private String setSpindleNum(SilkPrintMessage silk) {

        return int2chineseNum(Integer.valueOf(silk.getSpindleNum()));
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
                .replaceAll("零+", "零").replaceAll("零$", "").replaceAll("一十", "十");
    }
    private String getNightWhite(SilkPrintMessage qrCode,String team) {
        return  "" ;
 /*       if(!ObjectUtils.isEmpty(qrCode.getWhiteNight())){
             return  "1".equals(qrCode.getWhiteNight())?"白":"夜";
        }
        if(ObjectUtils.isEmpty(qrCode.getQrCode())){
            return "" ;
        }else {
            if(team.length()>1){
                    return  "" ;
            }else {
                int len = qrCode.getQrCode().length() ;
                String a = qrCode.getQrCode().substring(len - 3, len - 2);
                return  a.equals("1")?"白/":"夜/" ;
            }

        }*/
    }

    private String getHanTeam(String team) {
        /*String hanTeam = "" ;
        switch (team){
            case "1" :
                hanTeam = "甲" ;
                break;
            case "2" :
                hanTeam = "乙" ;
                break;
            case "3" :
                hanTeam = "甲/中";
                break;
            case "4" :
                hanTeam = "乙/中" ;
                break;
            case "5" :
                hanTeam = "丙" ;
                break;
            case "6" :
                hanTeam = "丙/中" ;
                break;
            default:
                if(!ObjectUtils.isEmpty(team)){
                    hanTeam =team;
                    return  hanTeam ;
                }
                break;
        }*/
        return team;
    }


}
