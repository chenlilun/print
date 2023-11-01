package com.example.print.print.vo.print;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2022-03-14 15:39:1
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Silkbarcodes {

    @JsonProperty("autoDoffingTimestamp")
    private int autodoffingtimestamp;
    private Batch batch;
    @JsonProperty("batchChanged")
    private boolean batchchanged;
    @JsonProperty("batchNo")
    private String batchno;
    private String code;
    @JsonProperty("codeDate")
    private long codedate;
    @JsonProperty("codeDoffingNum")
    private int codedoffingnum;
    @JsonProperty("createDateTime")
    private long createdatetime;
    private boolean deleted;
    @JsonProperty("doffingNum")
    private String doffingnum;
    private String id;
    private int item;
    @JsonProperty("lineMachine")
    private Linemachine linemachine;
    @JsonProperty("modifyDateTime")
    private long modifydatetime;
    public void setAutodoffingtimestamp(int autodoffingtimestamp) {
         this.autodoffingtimestamp = autodoffingtimestamp;
     }
     public int getAutodoffingtimestamp() {
         return autodoffingtimestamp;
     }

    public void setBatch(Batch batch) {
         this.batch = batch;
     }
     public Batch getBatch() {
         return batch;
     }

    public void setBatchchanged(boolean batchchanged) {
         this.batchchanged = batchchanged;
     }
     public boolean getBatchchanged() {
         return batchchanged;
     }

    public void setBatchno(String batchno) {
         this.batchno = batchno;
     }
     public String getBatchno() {
         return batchno;
     }

    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setCodedate(long codedate) {
         this.codedate = codedate;
     }
     public long getCodedate() {
         return codedate;
     }

    public void setCodedoffingnum(int codedoffingnum) {
         this.codedoffingnum = codedoffingnum;
     }
     public int getCodedoffingnum() {
         return codedoffingnum;
     }

    public void setCreatedatetime(long createdatetime) {
         this.createdatetime = createdatetime;
     }
     public long getCreatedatetime() {
         return createdatetime;
     }

    public void setDeleted(boolean deleted) {
         this.deleted = deleted;
     }
     public boolean getDeleted() {
         return deleted;
     }

    public void setDoffingnum(String doffingnum) {
         this.doffingnum = doffingnum;
     }
     public String getDoffingnum() {
         return doffingnum;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setItem(int item) {
         this.item = item;
     }
     public int getItem() {
         return item;
     }

    public void setLinemachine(Linemachine linemachine) {
         this.linemachine = linemachine;
     }
     public Linemachine getLinemachine() {
         return linemachine;
     }

    public void setModifydatetime(long modifydatetime) {
         this.modifydatetime = modifydatetime;
     }
     public long getModifydatetime() {
         return modifydatetime;
     }

}
