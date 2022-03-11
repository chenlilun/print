package com.example.print.p;

import lombok.Data;

@Data
public class SilkPrintMessage {
    private String spec;
    private String batchNo;
    private Boolean blank;
    private String classes;
    private String lineMachine;
    private String doffDate;
    private String doffDateBefore;
    private String doffNo;
    private String spindleNum;
    private String qrCode;
    private String silkCarCode;
     private String cls;;
    private String whiteNight;//1白班 2夜班

    public SilkPrintMessage(String spec, String batchNo, String classes, String lineMachine, String doffDate, String doffNo, String spindleNum, String qrCode,Boolean blank) {
        this.spec = spec;
        this.batchNo = batchNo;
        this.classes = classes;
       this.lineMachine=lineMachine;
        this.doffDate = doffDate;
        this.doffNo = doffNo;
        this.spindleNum = spindleNum;
        this.qrCode = qrCode;
        this.blank = blank;
    }
    public SilkPrintMessage(){}
    @Override
    public String toString() {
        return "SilkPrintMessage{" +
                "spec='" + spec + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", classes='" + classes + '\'' +
                ", lineMachine='" + lineMachine + '\'' +
                ", doffDate='" + doffDate + '\'' +
                ", doffNo='" + doffNo + '\'' +
                ", spindleNum='" + spindleNum + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", silkCarCode='" + silkCarCode + '\'' +
                '}';
    }
}
