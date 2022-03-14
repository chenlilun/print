package com.example.print.print.vo.print;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Auto-generated: 2022-03-14 15:39:0
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Batch {

    @JsonProperty("batchNo")
    private String batchno;
    @JsonProperty("centralValue")
    private int centralvalue;
    @JsonProperty("createDateTime")
    private long createdatetime;
    private boolean deleted;
    @JsonProperty("holeNum")
    private int holenum;
    private String id;
    @JsonProperty("modifyDateTime")
    private long modifydatetime;
    @JsonProperty("multiDyeing")
    private boolean multidyeing;
    private String note;
    private Product product;
    @JsonProperty("silkWeight")
    private double silkweight;
    private String spec;
    @JsonProperty("tubeColor")
    private String tubecolor;
    @JsonProperty("tubeWeight")
    private double tubeweight;
    private Workshop workshop;
    public void setBatchno(String batchno) {
         this.batchno = batchno;
     }
     public String getBatchno() {
         return batchno;
     }

    public void setCentralvalue(int centralvalue) {
         this.centralvalue = centralvalue;
     }
     public int getCentralvalue() {
         return centralvalue;
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

    public void setHolenum(int holenum) {
         this.holenum = holenum;
     }
     public int getHolenum() {
         return holenum;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setModifydatetime(long modifydatetime) {
         this.modifydatetime = modifydatetime;
     }
     public long getModifydatetime() {
         return modifydatetime;
     }

    public void setMultidyeing(boolean multidyeing) {
         this.multidyeing = multidyeing;
     }
     public boolean getMultidyeing() {
         return multidyeing;
     }

    public void setNote(String note) {
         this.note = note;
     }
     public String getNote() {
         return note;
     }

    public void setProduct(Product product) {
         this.product = product;
     }
     public Product getProduct() {
         return product;
     }

    public void setSilkweight(double silkweight) {
         this.silkweight = silkweight;
     }
     public double getSilkweight() {
         return silkweight;
     }

    public void setSpec(String spec) {
         this.spec = spec;
     }
     public String getSpec() {
         return spec;
     }

    public void setTubecolor(String tubecolor) {
         this.tubecolor = tubecolor;
     }
     public String getTubecolor() {
         return tubecolor;
     }

    public void setTubeweight(double tubeweight) {
         this.tubeweight = tubeweight;
     }
     public double getTubeweight() {
         return tubeweight;
     }

    public void setWorkshop(Workshop workshop) {
         this.workshop = workshop;
     }
     public Workshop getWorkshop() {
         return workshop;
     }

}
