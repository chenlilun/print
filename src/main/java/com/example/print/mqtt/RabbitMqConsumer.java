package com.example.print.mqtt;

import com.example.print.bean.MqttBean;
import com.example.print.bean.PackageBox;
import com.example.print.bean.PrintData;
import com.example.print.bean.SilkCarOnline;
import com.example.print.config.RabbitConfig;
import com.example.print.okhttp.OkHttpUtils;
import com.example.print.print.App;
import com.example.print.print.Tcpclient;
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
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

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
    private App app;
    @Autowired
    private Tcpclient tcpclient;
    private Map<String, String> map = new HashMap<>();

    {
        map.put("Z1", "10.12.4.99");
        map.put("Z2", "10.12.7.69") ;
        map.put("Z3", "10.12.7.48") ;
        map.put("Z4", "10.61.101.200") ;
    }


    //日志
    private Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = "pal_queue", containerFactory = "firstFactory")
    public void consumer(String content, Channel channel, Message message) {
        String msg = ""  ;
        try {
             msg = new String(message.getBody(), "gb2312");
        } catch (Exception e) {
            logger.error("业务逻辑异常:" + e.getMessage());
            logger.error("业务逻辑异常数据:" + content);
        }


        try {
            System.out.println("msg===" + msg);
            PackageBox packageBox = new Gson().fromJson(msg, PackageBox.class);
            if (!ObjectUtils.isEmpty(packageBox) && ("POY".equals(packageBox.getProductName()) ||
                    "FDY".equals(packageBox.getProductName())
            )) {
//                Tcpclient.startServerSocket("10.12.3.66",9100,packageBox);
                String ip = map.get(packageBox.getLine());
                if (!ObjectUtils.isEmpty(ip)) {
                    System.out.println(ip + "+++++++" + packageBox.getLine());
                    tcpclient.startServerSocket(ip, 9100, packageBox);
                }

                System.out.println("=====" + msg);
            }
            System.out.println("------------------");
        } catch (Exception e) {
            logger.error("业务逻辑异常:" + e.getMessage());
            logger.error("业务逻辑异常数据:" + content);
            e.printStackTrace();
        } finally {


            try {

//                logger.error("消费mq开始:" + message.getMessageProperties().getDeliveryTag());
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//                logger.error("消费mq成功:" + message.getMessageProperties().getDeliveryTag());
            } catch (IOException e) {
                logger.error("消费mq失败:" + message.getBody().toString());
                e.printStackTrace();
            }
        }

    }


}
