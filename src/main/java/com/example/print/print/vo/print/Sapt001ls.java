package com.example.print.print.vo.print;

import lombok.Data;

/**
 * Auto-generated: 2022-03-14 15:39:0
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Sapt001ls {

    private boolean deleted;
    private String id;
    private String lgobe;
    private String lgort;
    public void setDeleted(boolean deleted) {
         this.deleted = deleted;
     }
     public boolean getDeleted() {
         return deleted;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setLgobe(String lgobe) {
         this.lgobe = lgobe;
     }
     public String getLgobe() {
         return lgobe;
     }

    public void setLgort(String lgort) {
         this.lgort = lgort;
     }
     public String getLgort() {
         return lgort;
     }

}
