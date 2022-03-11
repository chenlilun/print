package com.example.print.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

//在线丝车位置信息
@Data
public class SilkCarOnLinePosition {
    private int orderBy;//编号
    private String lineMachine;//产线机台
    private String doffNo;//落次
    private String dofferId;//落筒人

//    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date doffTime;//落筒时间
}
