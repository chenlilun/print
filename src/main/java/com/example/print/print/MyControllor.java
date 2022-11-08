package com.example.print.print;

import com.example.print.bean.Book;
import com.example.print.bean.MqttBean;
import com.example.print.bean.PrintData;
import com.example.print.bean.SilkCarOnline;
import com.example.print.okhttp.OkHttpUtils;
import com.example.print.print.vo.PrintSelectSilkBarCodesVo;
import com.example.print.service.DoffService;
import com.example.print.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyControllor {
    @Autowired
    FileUtils fileUtils ;
    @Autowired
    OkHttpUtils okHttpUtils ;
    @Autowired
    DoffService doffService ;
    private static final Logger log = LoggerFactory.getLogger(OkHttpUtils.class);


    //打印
    @PostMapping("/printBooksCodes")
    public String printCarSilkCode(@RequestBody List<Book> books){
        try{
            doffService.printCarSilkCode(books);
            return "打印成功";
        }catch (Exception e){
            e.printStackTrace();
            return "打印失败";
        }
    }
    //提前打选中落次条码打印
    @PostMapping("/printSilkCodesBySilkBarCodes")
    public  String   printSilkCodesBySilkBarCodes(@RequestBody PrintSelectSilkBarCodesVo printSelectSilkBarCodesVo) {
        try{
            doffService.printSilkCodesBySilkBarCodes(printSelectSilkBarCodesVo);
            return "打印成功";
        }catch (Exception e){
            e.printStackTrace();
            return "打印失败";
        }

    }
}
