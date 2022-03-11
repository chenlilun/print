package com.example.print.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

//丝车位置几行几列（游离丝锭记录表）
@Data
public class SilkCarRowCol extends BaseEntity {
    private int orderBy;
    private Integer sortBy;
    private String sideType;//A、B面
    private int row;//行
    private int col;//列
    private String spindleNum;//锭位
    private String silkCode;
    private String lineName;
    private Boolean blank;
    private String machineName;
    private String batchNo;//批号
    private String spec;//规格
    private String grade;//等级
    private String doffNo;//落次

//    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date doffingTime;//落筒时间
    private String dofferId;
    private boolean grabFlag=true;//抓取标志
    private boolean eliminateFlag=true;//剔除标志
    private String doffType;//落筒类型
    private List<String> silkExceptions;//异常信息
    private String silkRecordId;//丝车记录
}
