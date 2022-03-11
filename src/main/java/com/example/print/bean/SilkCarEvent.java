package com.example.print.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//丝车事件类
@Data
public class SilkCarEvent {
    private String post;// 岗位：落筒、剥丝、织袜、染判、外观、测纤、打包等   Const类
    private String operator;//操作人
    private String operate;//操作类型：落筒，解绑，织袜，拼车，打包等等
    private List<String> silkCodes = new ArrayList<>();//丝锭信息

//    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date operateTime;//操作时间
    private String exception;
    private boolean recover=false;
    private SilkCarEvent(String post, String operator, String operate, Date operateTime) {
        this.post = post;
        this.operator = operator;
        this.operate = operate;
        this.operateTime = operateTime;
    }

    public static SilkCarEvent createEvent(String post, String operate, String operator, Date operateTime) {
        return new SilkCarEvent(post, operator, operate, operateTime);
    }

}
