package com.example.print.print.vo.print;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
/**
 * Auto-generated: 2022-03-14 15:39:1
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Linemachine {

    @JsonProperty("createDateTime")
    private long createdatetime;
    private boolean deleted;
    private String id;
    private int item;
    private Line line;
    @JsonProperty("modifyDateTime")
    private long modifydatetime;
    @JsonProperty("spindleNum")
    private int spindlenum;
    @JsonProperty("spindleSeq")
    private List<Integer> spindleseq;
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

    public void setLine(Line line) {
         this.line = line;
     }
     public Line getLine() {
         return line;
     }

    public void setModifydatetime(long modifydatetime) {
         this.modifydatetime = modifydatetime;
     }
     public long getModifydatetime() {
         return modifydatetime;
     }

    public void setSpindlenum(int spindlenum) {
         this.spindlenum = spindlenum;
     }
     public int getSpindlenum() {
         return spindlenum;
     }

    public void setSpindleseq(List<Integer> spindleseq) {
         this.spindleseq = spindleseq;
     }
     public List<Integer> getSpindleseq() {
         return spindleseq;
     }

}
