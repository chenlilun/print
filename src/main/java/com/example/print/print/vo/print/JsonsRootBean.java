package com.example.print.print.vo.print;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
/**
 * Auto-generated: 2022-03-14 15:39:0
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class JsonsRootBean {

    @JsonProperty("mesAutoPrinter")
    private Mesautoprinter mesautoprinter;
    @JsonProperty("silkBarcodes")
    private List<Silkbarcodes> silkbarcodes;
    public void setMesautoprinter(Mesautoprinter mesautoprinter) {
         this.mesautoprinter = mesautoprinter;
     }
     public Mesautoprinter getMesautoprinter() {
         return mesautoprinter;
     }

    public void setSilkbarcodes(List<Silkbarcodes> silkbarcodes) {
         this.silkbarcodes = silkbarcodes;
     }
     public List<Silkbarcodes> getSilkbarcodes() {
         return silkbarcodes;
     }

}
