package com.example.print.bean;

import lombok.Data;

@Data
public class MqttBean {
    private  String clieId;
    private  String msg;
    private  String silkCarCode;
    private  int currentPage =1 ;
    private  int pageSize =50 ;
    private  boolean printFlag = false;
}
