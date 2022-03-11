package com.example.print.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PrintData {
    private  DataPrint data ;
     public static   class DataPrint  {
      public   List<SilkCarOnline> silkCarOnlines = new ArrayList<>();
    }
}
