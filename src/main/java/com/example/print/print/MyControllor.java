package com.example.print.print;

import com.example.print.bean.MqttBean;
import com.example.print.bean.PrintData;
import com.example.print.bean.SilkCarOnline;
import com.example.print.bean.User;
import com.example.print.mapper.UserMapper;
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

import javax.annotation.Resource;
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
//    @Autowired
//    OkHttpUtils okHttpUtils ;
@Resource
private UserMapper userMapper;
    @GetMapping("/bb/{line}")
    public      List<User> getBb(@PathVariable String line){
//        String url = "http://www.baidu.com";
//        System.out.println(okHttpUtils.httpGet(url));
        fileUtils.writeText("D:\\printService\\config.txt",line,false);
        log.error("url为null!");
//        List<User> users = userMapper.selectList(null);
        return null;
    }

    @GetMapping("/setTeam/{team}")
    public String setTeam(@PathVariable String team){
//        String url = "http://www.baidu.com";
//        System.out.println(okHttpUtils.httpGet(url));
        String realTeam = getTeam(team) ;
        fileUtils.writeText("D:\\printService\\team.txt",realTeam,false);
        log.error("url为null!");
        return "设置班组成功" ;
    }

    private String getTeam(String team) {
//        String hanT fileUtils.writeText("D:\\printService\\team.txt",team,false);
        String shuTeam = ""  ;
        switch (team){
            case  "甲":
                shuTeam =  "1"  ; break;
            case  "乙":
                shuTeam =  "2"  ; break;
            case  "甲中":
                shuTeam =  "3"  ; break;
            case  "乙中":
                shuTeam =  "4"  ; break;
            case  "丙":
                shuTeam =  "5"  ; break;
            case  "丙中":
                shuTeam =  "6"  ; break;
            default:
                if(!ObjectUtils.isEmpty(team)){
                    shuTeam =team;
                }

        }
        return shuTeam;
    }

    @GetMapping("/cc")
    public String getBbb(){
        MqttBean mqttBean1 = new MqttBean() ;
        mqttBean1.setSilkCarCode("9700P30293");
        Gson gson1 = new Gson() ;
        String postData = gson1.toJson(mqttBean1);
        Map<String, String> headers = new HashMap<>() ;
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZW5neWkiLCIxIjoicGFzc3dvcmQiLCJpYXQiOjE2MDA2NjM3Nzl9.J9-mIgeQeghzqerf5jA_DF-Ee8NGfBJ5ZSdrgit5RmU")  ;
        headers.put("Content-Type","application/json") ;
        String printData = okHttpUtils.httpPostJson("http://192.168.128.133:8090/api/doff/getSilkOnLineForWorkshop", headers, postData);

        PrintData jjjj = null;
        try {
             jjjj = new Gson().fromJson(printData, PrintData.class);

        }catch (Exception e){
            e.printStackTrace();
        }

//        doffService.printCarSilkCode(jjjj.getData().silkCarOnlines);
//        List<SilkCarOnline> silkCarOnlines = jjjj.getData().silkCarOnlines;
//        for (int i = 0; i < silkCarOnlines.size(); i++) {
//            silkCarOnlines.get(i).setDoffTime(null);
//            silkCarOnlines.get(i).getBatch().setCreateTime(null);
//            silkCarOnlines.get(i).getBatch().setModifiTime(null);
//        }
//        jjjj.getData().silkCarOnlines = silkCarOnlines ;
        String dddddd = okHttpUtils.httpPostJson2("http://192.168.128.133:8090/api/doff/printCarSilkCode", headers,new Gson().toJson( jjjj.getData().silkCarOnlines));
        System.out.println("AAAAAAAAA===="+dddddd);
        return "bb" ;
    }


    //打印
    @PostMapping("/printCarSilkCode")
    public String printCarSilkCode(@RequestBody List<SilkCarOnline> silkCarOnlineList){
        try{
            doffService.printCarSilkCode(silkCarOnlineList);
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
