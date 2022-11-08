package com.example.print.mqtt;

import com.example.print.config.RabbitConfig;
import com.example.print.okhttp.OkHttpUtils;
import com.google.gson.Gson;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//@RabbitListener(queues = RabbitConfig.QUEUE)
@Component
public class RabbitMqConsumer {

    @Autowired
    private OkHttpUtils okHttpUtils;

    //日志
    private Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class);
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void consumer(String content, Channel channel, Message message) {
        System.out.println("自己mq消费了=====================");
        System.out.println("mq消费了===========" + content);
        logger.error("收到mq打印信号"+content);


        try {

            }catch (Exception e){

        } finally {
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
