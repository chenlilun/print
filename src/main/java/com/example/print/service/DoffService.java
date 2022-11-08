package com.example.print.service;


import com.example.print.bean.*;
import com.example.print.okhttp.OkHttpUtils;
import com.example.print.p.SilkPrintMessage;
import com.example.print.print.vo.PrintSelectSilkBarCodesVo;
import com.example.print.utils.DateUtils;
import com.example.print.utils.FileUtils;
import com.example.print.utils.PrintUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class DoffService {
    @Autowired
    FileUtils fileUtils;
    @Autowired
    private OkHttpUtils okHttpUtils;
    //日志
    private Logger logger = LoggerFactory.getLogger(DoffService.class);

    //打印在线丝车标签
    public void printCarSilkCodes(List<SilkCarOnline> silkCarOnlineList) {
        List<SilkPrintMessage> silkPrintMessageList = new ArrayList<>();
        silkCarOnlineList.forEach(silkCarOnline -> {
            silkCarOnline.getSilkCarRowColList().stream().forEach(silkCarRowCol -> {
     /*           if (silkCarRowCol.getBlank() != null && silkCarRowCol.getBlank()) {
                    SilkPrintMessage silkPrintMessage = new SilkPrintMessage();
                    silkPrintMessage.setBlank(silkCarRowCol.getBlank());
//                    silkPrintMessage.setDoffDate(new Date());
                    silkPrintMessageList.add(silkPrintMessage);
                } else {*/
                SilkPrintMessage silkPrintMessage = new SilkPrintMessage();
                silkPrintMessage.setBatchNo(silkCarRowCol.getBatchNo());
                silkPrintMessage.setClasses("");
//                    silkPrintMessage.setDoffDate(new SimpleDateFormat("yyMMdd HH:mm").format(silkCarRowCol.getDoffingTime()));
                try {
//                        silkPrintMessage.setDoffDate(new SimpleDateFormat("yyMMdd HH:mm").format());
                    silkPrintMessage.setDoffDate(DateUtils.reduceEight(silkCarRowCol.getDoffingTime()));
                    if ("C1C2C3C4".contains(silkCarRowCol.getLineName())) {
                        silkPrintMessage.setDoffDateBefore(DateUtils.reduceEightBefore(silkCarRowCol.getDoffingTime(), silkCarRowCol.getLineName()));
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {

                }
                silkPrintMessage.setBlank(silkCarRowCol.getBlank());
                silkPrintMessage.setLineMachine(silkCarRowCol.getLineName() + "-" + silkCarRowCol.getMachineName());
                silkPrintMessage.setSpec(silkCarRowCol.getSpec());
                silkPrintMessage.setSpindleNum(silkCarRowCol.getSpindleNum());
                silkPrintMessage.setQrCode(silkCarRowCol.getSilkCode());
                silkPrintMessage.setDoffNo(silkCarRowCol.getDoffNo());
                silkPrintMessage.setSilkCarCode(silkCarOnline.getSilkCarCode());
                silkPrintMessageList.add(silkPrintMessage);
                /*     }*/
            });
            silkCarOnline.setDeleteFlag(true);
        });
//        print(silkPrintMessageList, silkCarOnlineList.get(0).getRemark());
        String printName = fileUtils.readText("D:\\printService\\printMachine.txt").replace("\n", "");
//        print(silkPrintMessageList, "BTP-2200E(U) 1");

//        String machine = fileUtils.readText("D:\\printService\\printMachine.txt").replace("\n", "");
        if (ObjectUtils.isEmpty(printName)) {
            print(silkPrintMessageList, "ZDesigner ZT410-300dpi ZPL");
        } else {
            print(silkPrintMessageList, printName);
        }
    }

    //打印在线丝车标签
    public void printCarSilkCode(List<Book> books) {
        List<SilkPrintMessage> silkPrintMessageList = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            SilkPrintMessage silkPrintMessage = new SilkPrintMessage();
            silkPrintMessage.setBatchNo(books.get(i).bookName.length()>10?books.get(i).bookName.substring(0,9):books.get(i).bookName);
            silkPrintMessage.setClasses("");
            silkPrintMessage.setLineMachine("");
            silkPrintMessage.setSpec("");
            silkPrintMessage.setSpindleNum("");
//            silkPrintMessage.setDoffDate(books.get(i).getCreateTime()==null?"":books.get(i).getCreateTime());
            silkPrintMessage.setDoffDate(books.get(i).bookType);
            silkPrintMessage.setQrCode(books.get(i).getBookCode());
            silkPrintMessage.setDoffNo("");
//            silkPrintMessage.setSilkCarCode(books.get(i).getBookCode());
            silkPrintMessageList.add(silkPrintMessage);
        }
        String printName = fileUtils.readText("D:\\printService\\printMachine.txt").replace("\n", "");
        if (ObjectUtils.isEmpty(printName)) {
//            print(silkPrintMessageList, "ZDesigner ZT410-300dpi ZPL");
            print(silkPrintMessageList, "BTP-2200E(U) 1");
        } else {
//            print(silkPrintMessageList, printName);
            print(silkPrintMessageList, "BTP-2200E(U) 1");
        }
    }

    //排序并调用打印功能
    public void print(List<SilkPrintMessage> silkPrintMessageList, String printerName) {
        silkPrintMessageList.stream().
//                sorted((a,b)->{
//            if(a.getLineMachine().compareTo(b.getLineMachine())==0){
//                if(a.getDoffNo().compareTo(b.getDoffNo())==0){
//                    return a.getQrCode().compareTo(b.getQrCode());
//                }
//                return a.getDoffNo().compareTo(b.getDoffNo());
//            }
//            return a.getLineMachine().compareTo(b.getLineMachine());
//        }).
        collect(Collectors.toList()).stream().forEach(silkPrintMessage -> System.out.println(silkPrintMessage));
        PrintUtil.printSilkMessage(silkPrintMessageList, printerName);
    }

    public void printSilkCodesBySilkBarCodes(PrintSelectSilkBarCodesVo printSelectSilkBarCodesVo) {

        Gson gson1 = new Gson();
        String postData = gson1.toJson(printSelectSilkBarCodesVo);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZW5neWkiLCIxIjoicGFzc3dvcmQiLCJpYXQiOjE2MDA2NjM3Nzl9.J9-mIgeQeghzqerf5jA_DF-Ee8NGfBJ5ZSdrgit5RmU");
        headers.put("Content-Type", "application/json");
//        String printData = okHttpUtils.httpPostJson("http://10.77.0.24:8090/api/doff/getSilkOnLineForWorkshop", headers, postData);
        String url = FileUtils.readText("D:\\printService\\url.txt").replaceAll("\n", "");
        String printData = okHttpUtils.httpPostJson(url + "/api/code/printCheckSilkBarCode", headers, postData);
        System.out.println("AAAAAAAA" + printData);
        logger.error(printData);
        JsonResult jjjj = null;
        try {
            jjjj = new Gson().fromJson(printData, JsonResult.class);
//            List<SilkPrintMessage> printMessages = (List<SilkPrintMessage>) jjjj.getData();
//            System.out.println( "***" +printMessages);
            List<SilkPrintMessage> printMessages = jjjj.getData();
            if(ObjectUtils.isEmpty(printSelectSilkBarCodesVo.getPrinter())){
                print(printMessages, FileUtils.readText("D:\\printService\\printMachine.txt").replaceAll("\n", ""));
            }else {
                print(printMessages, printSelectSilkBarCodesVo.getPrinter());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
