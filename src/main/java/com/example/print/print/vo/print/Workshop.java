package com.example.print.print.vo.print;

import lombok.Data;

/**
 * Auto-generated: 2022-03-14 15:39:0
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class Workshop {

    private String id;
    private String name;
    private String code;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

}
