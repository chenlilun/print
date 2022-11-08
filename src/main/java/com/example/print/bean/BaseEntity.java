package com.example.print.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

//基础实体类
@Data
public class BaseEntity {
    private String id;
    private String creator;//创建人
    private Date createTime=new Date();//创建时间
    private String remark;//备注
    private boolean deleteFlag;//删除标志

//    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiTime;//修改时间
    private String modifier;//修改人
}
