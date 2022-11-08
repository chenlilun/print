package com.example.print.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Book {

    /**
     * updateId : 35
     * bookCode : 10000001
     * createTime : 2022-09-05 14:09:35
     * author : 金庸
     * createId : 35
     * updateTime : 2022-09-05 14:10:54
     * id : 1
     * delFlag : 0
     * bookName : 射雕英雄传
     * bookRemark : 一本武侠小说的简介
     * bookType : 武侠类
     */
    @SerializedName("updateId")
    public int updateId;
    @SerializedName("bookCode")
    public String bookCode;
    @SerializedName("createTime")
    public String createTime;
    @SerializedName("author")
    public String author;
    @SerializedName("createId")
    public int createId;
    @SerializedName("updateTime")
    public String updateTime;
    @SerializedName("id")
    public int id;
    @SerializedName("delFlag")
    public String delFlag;
    @SerializedName("bookName")
    public String bookName;
    @SerializedName("bookRemark")
    public String bookRemark;
    @SerializedName("bookType")
    public String bookType;
}
