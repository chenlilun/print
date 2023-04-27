package com.example.print.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
@Data
public class PackageBox {

    /**
     * factoryCode : 9210
     * color : 桔红
     * line : Z4
     * pallet : M
     * produceTime : 2022-11-04T16:08:20
     * nx :
     * classesInfo : 甲
     * packageType : 普通箱包
     * productName : POY
     * spec : 368dtex/288f
     * materialText : POY-368dtex/288f-HA062006-AA
     * fullPackage : true
     * productType :
     * salesType : 内贸
     * batchNo : HA062006
     * palletCode :
     * workshop : 纺丝A车间
     * sz :
     * ProduceDate : 0001-01-01T00:00:00
     * factoryName : 杭州逸�巧�产工厂
     * palletType : 一类回收
     * teamInfo : A
     * productInfo : [{"grossWeight":778.98,"netWeight":744,"silkWeight":15.5,"classes":"甲","newProductCode":"A20221104AHA06200611A076","detail":[{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"}],"team":"A","printTime":"2022-11-04T16:08:20","silkCount":48}]
     * sequence : 76
     * uId :
     * lgort : 9231
     * material : 000000001000332052
     * foamType : POY新泡沫大孔
     * grade : AA
     */
    @SerializedName("factoryCode")
    public String factoryCode;
    @SerializedName("color")
    public String color;
    @SerializedName("line")
    public String line;
    @SerializedName("pallet")
    public String pallet;
    @SerializedName("produceTime")
    public String produceTime;
    @SerializedName("nx")
    public String nx;
    @SerializedName("classesInfo")
    public String classesInfo;
    @SerializedName("packageType")
    public String packageType;
    @SerializedName("productName")
    public String productName;
    @SerializedName("spec")
    public String spec;
    @SerializedName("materialText")
    public String materialText;
    @SerializedName("fullPackage")
    public boolean fullPackage;
    @SerializedName("productType")
    public String productType;
    @SerializedName("salesType")
    public String salesType;
    @SerializedName("batchNo")
    public String batchNo;
    @SerializedName("palletCode")
    public String palletCode;
    @SerializedName("workshop")
    public String workshop;
    @SerializedName("sz")
    public String sz;
    @SerializedName("ProduceDate")
    public String ProduceDate;
    @SerializedName("factoryName")
    public String factoryName;
    @SerializedName("palletType")
    public String palletType;
    @SerializedName("teamInfo")
    public String teamInfo;
    @SerializedName("productInfo")
    public List<ProductInfoEntity> productInfo;
    @SerializedName("sequence")
    public int sequence;
    @SerializedName("uId")
    public String uId;
    @SerializedName("lgort")
    public String lgort;
    @SerializedName("material")
    public String material;
    @SerializedName("foamType")
    public String foamType;
    @SerializedName("grade")
    public String grade;
    @Data
    public class ProductInfoEntity {
        /**
         * grossWeight : 778.98
         * netWeight : 744.0
         * silkWeight : 15.5
         * classes : 甲
         * newProductCode : A20221104AHA06200611A076
         * detail : [{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"},{"pkgWeight":0,"pkgDiameter":0,"pkgCode":"","doffDate":"0001-01-01T00:00:00"}]
         * team : A
         *
         * printTime : 2022-11-04T16:08:20
         * silkCount : 48.0
         */
        @SerializedName("grossWeight")
        public double grossWeight;
        @SerializedName("netWeight")
        public double netWeight;
        @SerializedName("silkWeight")
        public double silkWeight;
        @SerializedName("classes")
        public String classes;
        @SerializedName("newProductCode")
        public String newProductCode;
        @SerializedName("detail")
        public List<DetailEntity> detail;
        @SerializedName("team")
        public String team;
        @SerializedName("printTime")
        public String printTime;
        @SerializedName("silkCount")
        public double silkCount;
        @Data
        public class DetailEntity {
            /**
             * pkgWeight : 0.0
             * pkgDiameter : 0.0
             * pkgCode :
             * doffDate : 0001-01-01T00:00:00
             */
            @SerializedName("pkgWeight")
            public double pkgWeight;
            @SerializedName("pkgDiameter")
            public double pkgDiameter;
            @SerializedName("pkgCode")
            public String pkgCode;
            @SerializedName("doffDate")
            public String doffDate;
        }
    }
}
