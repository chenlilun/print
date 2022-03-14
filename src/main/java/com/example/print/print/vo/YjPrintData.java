package com.example.print.print.vo;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YjPrintData {

    /**
     * silkBarcodes : [{"batchNo":"HA011507","item":1,"code":"00UT00008","codeDate":1647187200000,"batch":{"note":"","batchNo":"HA011507","product":{"name":"POY","id":"5bffa63c8857b85a437d1f92"},"multiDyeing":false,"workshop":{"code":"A","deleted":false,"modifyDateTime":1557968602000,"sapT001lsPallet":[{"deleted":false,"lgort":"9247","lgobe":"A塑托库","id":"9247"}],"corporation":{"code":"9200","deleted":false,"modifyDateTime":1532162734000,"name":"逸暻","id":"5c81424f4e90f84e4542f097","createDateTime":1532162734000},"sapT001lsForeign":[{"deleted":false,"lgort":"9241","lgobe":"A外贸库","id":"9241"}],"name":"A车间","id":"5cdcb312039aab00016f6544","sapT001ls":[{"deleted":false,"lgort":"9231","lgobe":"A成品库","id":"9231"}],"createDateTime":1557967634000},"centralValue":272,"spec":"272dtex/144f","createDateTime":1603783716000,"tubeWeight":0.31,"silkWeight":15.5,"deleted":false,"tubeColor":"果绿","modifyDateTime":1628991564000,"holeNum":144,"id":"5f97cc2495b4b200013567da"},"createDateTime":1647134872000,"lineMachine":{"item":1,"deleted":false,"modifyDateTime":1624683602000,"line":{"doffingType":"MANUAL","deleted":false,"modifyDateTime":1557968878000,"workshop":{"name":"A车间","id":"5cdcb312039aab00016f6544"},"name":"A1","id":"5cdcb7ee039aab000173e671","createDateTime":1557968878000},"spindleNum":12,"spindleSeq":[1,2,3,4,5,6,7,8,9,10,11,12],"id":"5cdcb824039aab000173e809","createDateTime":1557968932000},"deleted":false,"modifyDateTime":1647134872000,"doffingNum":"A3","id":"622d489822fc7b000193f0f4","codeDoffingNum":8,"autoDoffingTimestamp":0,"batchChanged":false}]
     * mesAutoPrinter : {"name":"陈立坤","id":"a5274111f3e0466a82f6e24a79103f0d"}
     */
    @SerializedName("silkBarcodes")
    public List<SilkBarcodesEntity> silkBarcodes;
    @SerializedName("mesAutoPrinter")
    public MesAutoPrinterEntity mesAutoPrinter;

    public class SilkBarcodesEntity {
        /**
         * batchNo : HA011507
         * item : 1
         * code : 00UT00008
         * codeDate : 1647187200000
         * batch : {"note":"","batchNo":"HA011507","product":{"name":"POY","id":"5bffa63c8857b85a437d1f92"},"multiDyeing":false,"workshop":{"code":"A","deleted":false,"modifyDateTime":1557968602000,"sapT001lsPallet":[{"deleted":false,"lgort":"9247","lgobe":"A塑托库","id":"9247"}],"corporation":{"code":"9200","deleted":false,"modifyDateTime":1532162734000,"name":"逸暻","id":"5c81424f4e90f84e4542f097","createDateTime":1532162734000},"sapT001lsForeign":[{"deleted":false,"lgort":"9241","lgobe":"A外贸库","id":"9241"}],"name":"A车间","id":"5cdcb312039aab00016f6544","sapT001ls":[{"deleted":false,"lgort":"9231","lgobe":"A成品库","id":"9231"}],"createDateTime":1557967634000},"centralValue":272,"spec":"272dtex/144f","createDateTime":1603783716000,"tubeWeight":0.31,"silkWeight":15.5,"deleted":false,"tubeColor":"果绿","modifyDateTime":1628991564000,"holeNum":144,"id":"5f97cc2495b4b200013567da"}
         * createDateTime : 1647134872000
         * lineMachine : {"item":1,"deleted":false,"modifyDateTime":1624683602000,"line":{"doffingType":"MANUAL","deleted":false,"modifyDateTime":1557968878000,"workshop":{"name":"A车间","id":"5cdcb312039aab00016f6544"},"name":"A1","id":"5cdcb7ee039aab000173e671","createDateTime":1557968878000},"spindleNum":12,"spindleSeq":[1,2,3,4,5,6,7,8,9,10,11,12],"id":"5cdcb824039aab000173e809","createDateTime":1557968932000}
         * deleted : false
         * modifyDateTime : 1647134872000
         * doffingNum : A3
         * id : 622d489822fc7b000193f0f4
         * codeDoffingNum : 8
         * autoDoffingTimestamp : 0
         * batchChanged : false
         */
        @SerializedName("batchNo")
        public String batchNo;
        @SerializedName("item")
        public int item;
        @SerializedName("code")
        public String code;
        @SerializedName("codeDate")
        public long codeDate;
        @SerializedName("batch")
        public BatchEntity batch;
        @SerializedName("createDateTime")
        public long createDateTime;
        @SerializedName("lineMachine")
        public LineMachineEntity lineMachine;
        @SerializedName("deleted")
        public boolean deleted;
        @SerializedName("modifyDateTime")
        public long modifyDateTime;
        @SerializedName("doffingNum")
        public String doffingNum;
        @SerializedName("id")
        public String id;
        @SerializedName("codeDoffingNum")
        public int codeDoffingNum;
        @SerializedName("autoDoffingTimestamp")
        public int autoDoffingTimestamp;
        @SerializedName("batchChanged")
        public boolean batchChanged;

        public class BatchEntity {
            /**
             * note :
             * batchNo : HA011507
             * product : {"name":"POY","id":"5bffa63c8857b85a437d1f92"}
             * multiDyeing : false
             * workshop : {"code":"A","deleted":false,"modifyDateTime":1557968602000,"sapT001lsPallet":[{"deleted":false,"lgort":"9247","lgobe":"A塑托库","id":"9247"}],"corporation":{"code":"9200","deleted":false,"modifyDateTime":1532162734000,"name":"逸暻","id":"5c81424f4e90f84e4542f097","createDateTime":1532162734000},"sapT001lsForeign":[{"deleted":false,"lgort":"9241","lgobe":"A外贸库","id":"9241"}],"name":"A车间","id":"5cdcb312039aab00016f6544","sapT001ls":[{"deleted":false,"lgort":"9231","lgobe":"A成品库","id":"9231"}],"createDateTime":1557967634000}
             * centralValue : 272
             * spec : 272dtex/144f
             * createDateTime : 1603783716000
             * tubeWeight : 0.31
             * silkWeight : 15.5
             * deleted : false
             * tubeColor : 果绿
             * modifyDateTime : 1628991564000
             * holeNum : 144
             * id : 5f97cc2495b4b200013567da
             */
            @SerializedName("note")
            public String note;
            @SerializedName("batchNo")
            public String batchNo;
            @SerializedName("product")
            public ProductEntity product;
            @SerializedName("multiDyeing")
            public boolean multiDyeing;
            @SerializedName("workshop")
            public WorkshopEntity workshop;
            @SerializedName("centralValue")
            public int centralValue;
            @SerializedName("spec")
            public String spec;
            @SerializedName("createDateTime")
            public long createDateTime;
            @SerializedName("tubeWeight")
            public double tubeWeight;
            @SerializedName("silkWeight")
            public double silkWeight;
            @SerializedName("deleted")
            public boolean deleted;
            @SerializedName("tubeColor")
            public String tubeColor;
            @SerializedName("modifyDateTime")
            public long modifyDateTime;
            @SerializedName("holeNum")
            public int holeNum;
            @SerializedName("id")
            public String id;

            public class ProductEntity {
                /**
                 * name : POY
                 * id : 5bffa63c8857b85a437d1f92
                 */
                @SerializedName("name")
                public String name;
                @SerializedName("id")
                public String id;
            }

            public class WorkshopEntity {
                /**
                 * code : A
                 * deleted : false
                 * modifyDateTime : 1557968602000
                 * sapT001lsPallet : [{"deleted":false,"lgort":"9247","lgobe":"A塑托库","id":"9247"}]
                 * corporation : {"code":"9200","deleted":false,"modifyDateTime":1532162734000,"name":"逸暻","id":"5c81424f4e90f84e4542f097","createDateTime":1532162734000}
                 * sapT001lsForeign : [{"deleted":false,"lgort":"9241","lgobe":"A外贸库","id":"9241"}]
                 * name : A车间
                 * id : 5cdcb312039aab00016f6544
                 * sapT001ls : [{"deleted":false,"lgort":"9231","lgobe":"A成品库","id":"9231"}]
                 * createDateTime : 1557967634000
                 */
                @SerializedName("code")
                public String code;
                @SerializedName("deleted")
                public boolean deleted;
                @SerializedName("modifyDateTime")
                public long modifyDateTime;
                @SerializedName("sapT001lsPallet")
                public List<SapT001lsPalletEntity> sapT001lsPallet;
                @SerializedName("corporation")
                public CorporationEntity corporation;
                @SerializedName("sapT001lsForeign")
                public List<SapT001lsForeignEntity> sapT001lsForeign;
                @SerializedName("name")
                public String name;
                @SerializedName("id")
                public String id;
                @SerializedName("sapT001ls")
                public List<SapT001lsEntity> sapT001ls;
                @SerializedName("createDateTime")
                public long createDateTime;

                public class SapT001lsPalletEntity {
                    /**
                     * deleted : false
                     * lgort : 9247
                     * lgobe : A塑托库
                     * id : 9247
                     */
                    @SerializedName("deleted")
                    public boolean deleted;
                    @SerializedName("lgort")
                    public String lgort;
                    @SerializedName("lgobe")
                    public String lgobe;
                    @SerializedName("id")
                    public String id;
                }

                public class CorporationEntity {
                    /**
                     * code : 9200
                     * deleted : false
                     * modifyDateTime : 1532162734000
                     * name : 逸暻
                     * id : 5c81424f4e90f84e4542f097
                     * createDateTime : 1532162734000
                     */
                    @SerializedName("code")
                    public String code;
                    @SerializedName("deleted")
                    public boolean deleted;
                    @SerializedName("modifyDateTime")
                    public long modifyDateTime;
                    @SerializedName("name")
                    public String name;
                    @SerializedName("id")
                    public String id;
                    @SerializedName("createDateTime")
                    public long createDateTime;
                }

                public class SapT001lsForeignEntity {
                    /**
                     * deleted : false
                     * lgort : 9241
                     * lgobe : A外贸库
                     * id : 9241
                     */
                    @SerializedName("deleted")
                    public boolean deleted;
                    @SerializedName("lgort")
                    public String lgort;
                    @SerializedName("lgobe")
                    public String lgobe;
                    @SerializedName("id")
                    public String id;
                }

                public class SapT001lsEntity {
                    /**
                     * deleted : false
                     * lgort : 9231
                     * lgobe : A成品库
                     * id : 9231
                     */
                    @SerializedName("deleted")
                    public boolean deleted;
                    @SerializedName("lgort")
                    public String lgort;
                    @SerializedName("lgobe")
                    public String lgobe;
                    @SerializedName("id")
                    public String id;
                }
            }
        }

        public class LineMachineEntity {
            /**
             * item : 1
             * deleted : false
             * modifyDateTime : 1624683602000
             * line : {"doffingType":"MANUAL","deleted":false,"modifyDateTime":1557968878000,"workshop":{"name":"A车间","id":"5cdcb312039aab00016f6544"},"name":"A1","id":"5cdcb7ee039aab000173e671","createDateTime":1557968878000}
             * spindleNum : 12
             * spindleSeq : [1,2,3,4,5,6,7,8,9,10,11,12]
             * id : 5cdcb824039aab000173e809
             * createDateTime : 1557968932000
             */
            @SerializedName("item")
            public int item;
            @SerializedName("deleted")
            public boolean deleted;
            @SerializedName("modifyDateTime")
            public long modifyDateTime;
            @SerializedName("line")
            public LineEntity line;
            @SerializedName("spindleNum")
            public int spindleNum;
            @SerializedName("spindleSeq")
            public List<Integer> spindleSeq;
            @SerializedName("id")
            public String id;
            @SerializedName("createDateTime")
            public long createDateTime;

            public class LineEntity {
                /**
                 * doffingType : MANUAL
                 * deleted : false
                 * modifyDateTime : 1557968878000
                 * workshop : {"name":"A车间","id":"5cdcb312039aab00016f6544"}
                 * name : A1
                 * id : 5cdcb7ee039aab000173e671
                 * createDateTime : 1557968878000
                 */
                @SerializedName("doffingType")
                public String doffingType;
                @SerializedName("deleted")
                public boolean deleted;
                @SerializedName("modifyDateTime")
                public long modifyDateTime;
                @SerializedName("workshop")
                public WorkshopEntity workshop;
                @SerializedName("name")
                public String name;
                @SerializedName("id")
                public String id;
                @SerializedName("createDateTime")
                public long createDateTime;

                public class WorkshopEntity {
                    /**
                     * name : A车间
                     * id : 5cdcb312039aab00016f6544
                     */
                    @SerializedName("name")
                    public String name;
                    @SerializedName("id")
                    public String id;
                }
            }
        }
    }

    public class MesAutoPrinterEntity {
        /**
         * name : 陈立坤
         * id : a5274111f3e0466a82f6e24a79103f0d
         */
        @SerializedName("name")
        public String name;
        @SerializedName("id")
        public String id;
    }
}
