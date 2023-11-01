package com.example.print.service;


import com.example.print.bean.JsonResult;
import com.example.print.bean.PrintData;
import com.example.print.bean.SilkCarOnline;
import com.example.print.bean.SilkCarRowCol;
import com.example.print.okhttp.OkHttpUtils;
import com.example.print.p.SilkPrintMessage;
import com.example.print.print.vo.PrintSelectSilkBarCodesVo;
import com.example.print.print.vo.YjPrintData;
import com.example.print.print.vo.print.JsonsRootBean;
import com.example.print.print.vo.print.Silkbarcodes;
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
    public void printCarSilkCode(List<SilkCarOnline> silkCarOnlineList) {
        List<SilkPrintMessage> silkPrintMessageList = new ArrayList<>();
        silkCarOnlineList.forEach(silkCarOnline -> {

            silkCarOnline.getSilkCarRowColList().stream().sorted(Comparator.comparing(SilkCarRowCol::getSortBy).reversed()).forEach(silkCarRowCol -> {
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
                if(!ObjectUtils.isEmpty(silkCarOnline.getBatch())&&!ObjectUtils.isEmpty(silkCarOnline.getBatch().getProductName())){
                    silkPrintMessage.setProductName(silkCarOnline.getBatch().getProductName());
                }
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
//        print(silkPrintMessageList, "BTP-2200E(U) 1");
        if (ObjectUtils.isEmpty(printName)) {
            print(silkPrintMessageList, "ZDesigner ZT410-300dpi ZPL");
//            print(silkPrintMessageList, "BTP-2200E(U) 1");
        } else {
            print(silkPrintMessageList, printName);
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
            if (ObjectUtils.isEmpty(printSelectSilkBarCodesVo.getPrinter())) {
                print(printMessages, FileUtils.readText("D:\\printService\\printMachine.txt").replaceAll("\n", ""));
            } else {
                print(printMessages, printSelectSilkBarCodesVo.getPrinter());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printYjSilkPater(JsonsRootBean printData) {
        List<SilkPrintMessage> printMessages = convertPrint(printData);
        print(printMessages, FileUtils.readText("D:\\printService\\printMachine.txt").replaceAll("\n", ""));

        String s = new Gson().toJson(printData);
        System.out.println("逸暻打印程序：" + s);
    }

    private List<SilkPrintMessage> convertPrint(JsonsRootBean printData) {
        List<SilkPrintMessage> silkPrintMessageList = new ArrayList<>();
        List<Silkbarcodes> silkbarcodes = printData.getSilkbarcodes();
        for (int i = 0; i < silkbarcodes.size(); i++) {
            Silkbarcodes silkBarcode = silkbarcodes.get(i);
            for (int j = 0; j < silkBarcode.getLinemachine().getSpindlenum(); j++) {
                SilkPrintMessage message = new SilkPrintMessage();
                message.setSpec(silkBarcode.getBatch().getSpec());
                message.setBatchNo(silkBarcode.getBatch().getBatchno());
                message.setClasses("");
                message.setLineMachine(silkBarcode.getLinemachine().getLine().getName()+"-"+silkBarcode.getLinemachine().getItem());
                message.setDoffDate(getStr(silkBarcode.getCodedate()));
                message.setDoffNo(silkBarcode.getDoffingnum());
                message.setQrCode(singleAddZero(j+1,silkBarcode.getCode(),silkBarcode.getBatch().getWorkshop().getCode()));
                message.setSpindleNum((j+1)+"");
                message.setSilkCarCode(silkBarcode.getCode());
                message.setCls(silkBarcode.getBatch().getProduct().getName()); // 产品
                message.setWhiteNight("");
                silkPrintMessageList.add(message) ;
            }
        }

        return silkPrintMessageList;
    }

    private String singleAddZero(int j, String code, String workShopCode) {
//        j =
        String str1 = String.format("%02d", j);
        return code+str1+workShopCode;
    }

    public static void main(String[] args) {
        int n = 9;

        String str1 = String.format("%02d", n);

        System.out.println(str1);
    }
    public Date longToDate(long dateLong){
        Date date = new Date(dateLong);
        return date;
    }

    public  String getStr(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(longToDate(date));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        String format1 = format.format(cal.getTime());
        return format1;
    }
}
