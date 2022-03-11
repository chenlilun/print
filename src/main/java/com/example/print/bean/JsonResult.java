package com.example.print.bean;


import com.example.print.p.SilkPrintMessage;

import java.util.List;

//返回格式
public class JsonResult {
    private String status="400";
    private String msg="请求失败";
    private  List<SilkPrintMessage> data;
    private String token;

    public JsonResult(String status, String msg,  List<SilkPrintMessage> data, String token) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SilkPrintMessage> getData() {
        return data;
    }

    public void setData( List<SilkPrintMessage> data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
