package com.example.print.print.vo.print;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Auto-generated: 2022-03-14 15:39:1
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Line {

    @JsonProperty("createDateTime")
    private long createdatetime;
    private boolean deleted;
    @JsonProperty("doffingType")
    private String doffingtype;
    private String id;
    @JsonProperty("modifyDateTime")
    private long modifydatetime;
    private String name;
    private Workshop workshop;
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

    public void setDoffingtype(String doffingtype) {
         this.doffingtype = doffingtype;
     }
     public String getDoffingtype() {
         return doffingtype;
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

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setWorkshop(Workshop workshop) {
         this.workshop = workshop;
     }
     public Workshop getWorkshop() {
         return workshop;
     }

}
