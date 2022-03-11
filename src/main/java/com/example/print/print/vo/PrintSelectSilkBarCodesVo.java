package com.example.print.print.vo;

import lombok.Data;

import java.util.List;

@Data
public class PrintSelectSilkBarCodesVo {
    private List<String> silkBarcodeIds;
    private String printer;
}
