package com.example.print.bean;

import lombok.Data;

import java.math.BigDecimal;

//批号
@Data
public class Batch extends BaseEntity {
    private String batchNo;//批号
    private String spec;//规格
    private String workshop;//车间
    private String productName;//产品名称
    private String tubeColor;//管色
    private BigDecimal silkWeight;//丝锭重量
    private BigDecimal tubeWeight;//纸管重量
    private String centerValue;//中间值
    private String holeNum;//孔数
}
