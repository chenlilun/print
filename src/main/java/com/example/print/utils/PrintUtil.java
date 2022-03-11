package com.example.print.utils;

import com.example.print.p.SilkPrintMessage;
import com.example.print.p.SilkPrintMessageAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.List;

public class PrintUtil {
    //日志
    public static Logger logger = LoggerFactory.getLogger(PrintUtil.class);
    //驱动打印机公用方法
    public static void connectPrinter(Book book,String printerName){
        // 指定打印机打印（printerName打印机名称）
        HashAttributeSet hs = new HashAttributeSet();
        hs.add(new PrinterName(printerName, null));
        PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);
        if (pss.length == 0) {
            System.out.println("无法找到打印机:" + printerName);
            logger.info("无法找到打印机:" + printerName);
            return;
        }
        // 获取打印服务对象
        PrinterJob job = PrinterJob.getPrinterJob();
        // 写入书
        job.setPageable(book);
        try {
            // 添加指定的打印机
            job.setPrintService(pss[0]);
            // 打印执行
            job.print();
        } catch (PrinterException e) {
            System.out.println("================打印出现异常");
            logger.info("================打印出现异常:" + e.getMessage());
        }
    }
    public static void printSilkMessage(List<SilkPrintMessage> list, String printer){
        for(int i=0;i<list.size();i+=4){

            List<SilkPrintMessage> messageList=new ArrayList<SilkPrintMessage>();
            messageList.add(list.get(i));
            if(i+1<list.size()){
                messageList.add(list.get(i+1));
            }
            if(i+2<list.size()){
                messageList.add(list.get(i+2));
            }
            if(i+3<list.size()){
                messageList.add(list.get(i+3));
            }

            SilkPrintMessageAble.setSilkPrintMessageList(messageList);
            // 定义纸张高度
            int height=75;

            // 通俗理解就是书、文档
            Book book = new Book();
            // 打印格式
            PageFormat pf = new PageFormat();
            // 原点在纸张的左上方，x 指向右方，y 指向下方。
            pf.setOrientation(PageFormat.PORTRAIT);
            // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
            Paper p = new Paper();
            // 页面宽度 页面高度
            p.setSize(340, height);
            // x轴 y轴 宽度 高度
            p.setImageableArea(0, 0, 340, height);
            pf.setPaper(p);
            // 把 PageFormat 和 Printable 添加到书中，组成一个页面
            book.append(new SilkPrintMessageAble(), pf);

            PrintUtil.connectPrinter(book,printer);
        }
    }



}
