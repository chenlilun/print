package com.example.print.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//在运行丝车
@Data
public class SilkCarOnline extends BaseEntity{
    private String silkCarCode;//丝车
    private String grade;//等级
    private String dofferId;//落筒人

//    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date doffTime;//落筒时间
    private String doffType;//落筒类型:人工落筒/自动落筒/拼车
    private Batch batch;//批号
    private List<SilkCarRowCol> silkCarRowColList=new ArrayList<>();
    private String level;//丝车丝锭等级
    private List<SilkCarEvent> events=new ArrayList<>();
    private String status;//丝车状态
    private SilkNote silkNote;//丝车备注
    private List<SilkCarOnLinePosition> silkCarOnLinePositions;//丝车位置信息
    private String doffSpecId;

}
