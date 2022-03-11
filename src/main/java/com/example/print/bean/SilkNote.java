package com.example.print.bean;

import lombok.Data;

//丝锭备注
@Data
public class SilkNote extends BaseEntity{
    private String noteName;//备注名称
    private boolean feedBack=false;//是否反馈
}
