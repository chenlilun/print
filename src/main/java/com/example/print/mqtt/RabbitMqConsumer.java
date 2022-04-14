package com.example.print.mqtt;

import com.example.print.bean.MqttBean;
import com.example.print.bean.PrintData;
import com.example.print.bean.SilkCarOnline;
import com.example.print.config.RabbitConfig;
import com.example.print.okhttp.OkHttpUtils;
import com.example.print.service.DoffService;
import com.example.print.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RabbitListener(queues = RabbitConfig.QUEUE)
@Component
public class RabbitMqConsumer {

    @Autowired
    private DoffService doffService;
    @Autowired
    private OkHttpUtils okHttpUtils;

    //日志
    private Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class);
//    public static final String queue = FileUtils.readText("D:\\printService\\printMachine.txt").replace("\n", "");

//    @RabbitListener(queues = "${spring.rabbitmq.listener.queues}")
//    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void consumer(String content, Channel channel, Message message) {
        System.out.println("自己mq消费了=====================");
        System.out.println("mq消费了===========" + content);
        logger.error("收到mq打印信号"+content);


        try {
            if(content.length()>15){
                Gson silkGson = new Gson();
                PrintData printData = silkGson.fromJson(content, PrintData.class);
                System.out.println("对象===="+printData.toString());
                doffService.printCarSilkCodes(printData.getData().silkCarOnlines);
            } else {
                MqttBean mqttBean1 = new MqttBean();
                mqttBean1.setSilkCarCode(content);
                Gson gson1 = new Gson();
                String postData = gson1.toJson(mqttBean1);
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZW5neWkiLCIxIjoicGFzc3dvcmQiLCJpYXQiOjE2MDA2NjM3Nzl9.J9-mIgeQeghzqerf5jA_DF-Ee8NGfBJ5ZSdrgit5RmU");
                headers.put("Content-Type", "application/json");
                String url = FileUtils.readText("D:\\printService\\url.txt").replaceAll("\n", "");
                String printData = okHttpUtils.httpPostJson(url+"/api/doff/mqPrint", headers, postData);
                PrintData jjjj = null;
                try {
                    jjjj = new Gson().fromJson(printData, PrintData.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                doffService.printCarSilkCode(jjjj.getData().silkCarOnlines);
                System.out.println("打印完毕===============");
            }

//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        } finally {
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
