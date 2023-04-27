package com.example.print.print;

import com.example.print.bean.PackageBox;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tcpclient {

//    public static void main(String[] args) {
//        //String hex = Integer.toHexString(var);
//
//        String addressIP="192.168.116.240";
//        int addressPort=9100;
//
//        startServerSocket(addressIP,addressPort);
//    }

    public static void startServerSocket(String addressIP, int addressPort, PackageBox packageBox) {
        try {
            //serverSocket = new ServerSocket(addressPort);
            Socket acceptSocket = new Socket(addressIP, addressPort);

//            DataInputStream dis = new DataInputStream(acceptSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(acceptSocket.getOutputStream());

            while (true) {
                //boolean isClosed = isServerClose(acceptSocket);//判断是否断开

                boolean isClosed = acceptSocket.isClosed();

                //InetAddress spcketAddress = acceptSocket.getInetAddress();
                //String hostName = spcketAddress.getHostAddress();
                //String receiveMsg = dis.readUTF();

                //System.out.println("host name:"+hostName+"  msg:"+receiveMsg);
                sendData(dos, packageBox);
                break;//这里如果不中断会一直打印


            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static void sendData(DataOutputStream dos, PackageBox packageBox) {
//        String dataStr =
//                        "^XA\n" +
//                        "^CWZ,E:SIMSUN.TTF\n" +
//                        "^JMA^LL800^PW700^MD0^PR3^PON^LRN^LH0,0\n" +
//                        "^CI28" +
//                        "^FO192,64^GFA,16896,16896,00044,:Z64:\n" +
//                        "^FO280,100\n" +
//                        "^BQN,2,10\n" +
//                        "^FDHM,B0400"+packageBox.getProductInfo().get(0).getNewProductCode()+"^FS\n" +
//                        "^PQ1\n" +
//                        "^FT210,708^A0B,39,38^FH\\^FD" + packageBox.spec + "^FS\n" +
//                        "^FT265,708^A0B,39,38^FH\\^FD" + packageBox.getBatchNo() + "^FS\n" +
//                        "^FT313,708^A0B,39,38^FH\\^FD" + packageBox.getGrade() + "^FS\n" +
//                        "^FO382,600^AZB,48,48\n" + "^FD"+packageBox.getColor()+"^FS\n" +
//                        "^FT367,708^A0B,39,38^FH\\^FD" + Integer.valueOf((int) packageBox.getProductInfo().get(0).getSilkCount()) + "^FS\n" +
//                        "^FT467,708^A0B,39,38^FH\\^FD" + packageBox.getProductInfo().get(0).getNetWeight() + "KG" + "^FS\n" +
//                        "^FT515,708^A0B,39,38^FH\\^FD" + packageBox.getProductInfo().get(0).getGrossWeight() + "KG" + "^FS\n" +
//                        "^FT569,708^A0B,39,38^FH\\^FD" + getDateStr(packageBox.getProduceTime()) + "^FS\n" +
//                        "^FT613,708^A0B,39,38^FH\\^FD" + packageBox.getProductInfo().get(0).getNewProductCode() + "^FS\n" +
//                        "^PQ1,0,1,Y^XZ";

//        String dataStr = "^XA\\n \n" +
//                "^CWZ,E:\tSimHei.TTF\\n \n" +
//                "^JMA^LL800^PW1100^MD0^PR3^PON^LRN^LH0,0\\n \n" +
//                "^CI28 \n" +
//                "^FO480,350\n" +
//                "^BQN,2,15\n" +
//                "^FDHM,B0400FDA201015XD020701DZ2B201^FS \n" +
//                "^PQ1 \n" +
//                "^FO188,140^AZN,72,72 ^FD涤纶预取向丝POY^FS\n" +
//                "^FT158,216^A0N,39,38^FH\\^FD250dex/25f^FS\n" +
//                "^FT158,267^A0N,39,38^FH\\^FDXC5555400CD^FS\n" +
//                "^FT158,323^A0N,39,38^FH\\^FDAAA^FS\n" +
//                "^FT158,373^A0N,39,38^FH\\^FD99^FS\n" +
//                "^FO112,390^AZN,48,48 ^FD 黄蓝条^FS\n" +
//                "^FT158,471^A0N,39,38^FH\\^FD720.23KG^FS\n" +
//                "^FT158,526^A0N,39,38^FH\\^FD726.23KG^FS\n" +
//                "^FT158,578^A0N,39,38^FH\\^FD2022-12-23^FS\n" +
//                "^FT158,630^A0N,39,38^FH\\^FDA201015XD020701DZ2B201^FS\n" +
//                "^FO462,530^AZN,72,72 ^FD 甲001^FS\n" +
//                "^PQ1,0,1,Y^XZ";

        try {
            System.out.println("=========================================");
            ;
/*
            String dataStr111 = "^XA" +
                    "^CWZ,E:SimHei.TTF" +
                    "^JMA^LL800^PW1100^MD0^PR3^PON^LRN^LH0,0" +
                    "^CI26" +
                    "^FO480,200" +
                    "^BQN,2,10" +
                    "^FDHM,B0400FDA201015XD020701DZ2B201^FS" +
                    "^PQ1" +
                    "^FO188,140^AZN,72,72 ^FD涤纶预取向丝POY^FS" +
                    "^FT158,236^A0N,39,38^FH^FD250dex/25f^FS" +
                    "^FT158,287^A0N,39,38^FH^FDXC5555400CD^FS" +
                    "^FT158,343^A0N,39,38^FH^FDAAA^FS" +
                    "^FT158,393^A0N,39,38^FH^FD99^FS" +
                    "^FO112,410^AZN,48,48 ^FD 黄蓝条^FS" +
                    "^FT158,491^A0N,39,38^FH^FD720.23KG^FS" +
                    "^FT158,546^A0N,39,38^FH^FD726.23KG^FS" +
                    "^FT158,598^A0N,39,38^FH^FD2022-12-23^FS" +
                    "^FT158,650^A0N,39,38^FH^FDA201015XD020701DZ2B201^FS" +
                    "^FO462,530^AZN,72,72 ^FD 甲001^FS" +
                    "^PQ1,0,1,Y^XZ";*/



            String product = "POY".equals(packageBox.getProductName()) ? "涤纶预取向丝POY" : "涤纶牵伸丝FDY";
            String realDatas = "^XA^CWZ,E:SimHei.TTF^JMA^LL1182^PW1100^MD0^PR3^PON^LRN^LH0,0^CI28^FO709,296^BQN,2,20^FDHM," + packageBox.getProductInfo().get(0).getNewProductCode() +
                    "^FS^PQ1^FO278,180^AZN,106,96^FD" +
                    product
                    + "^FS^FT240,349^A0N,63,56^FH^FD" +
                    packageBox.getSpec() +
                    "^FS^FT240,424^A0N,58,56^FH^FD" +
                    packageBox.getBatchNo() +
                    "^FS^FT240,485^A0N,58,56^FH^FD" +
                    packageBox.getGrade() +
                    "^FS^FT240,560^A0N,58,56^FH^FD" +
                    Integer.valueOf((int) packageBox.getProductInfo().get(0).getSilkCount()) +
                    "^FS^FO226,580^AZN,71,71^FD" +
                    packageBox.getColor() +
                    "^FS^FT240,726^A0N,58,56^FH^FD" +
                    packageBox.getProductInfo().get(0).getNetWeight() + "KG" +
                    "^FS^FT240,807^A0N,58,56^FH^FD" +
                    packageBox.getProductInfo().get(0).getGrossWeight() + "KG" +
                    "^FS^FT240,870^A0N,58,56^FH^FD" +
                    getDateStr(packageBox.getProduceTime()) +
                    "^FS^FT240,950^A0N,58,56^FH^FD" +
                    packageBox.getProductInfo().get(0).getNewProductCode() +
                    "^FS^FO700,783^AZN,106,106^FD甲001^FS^PQ1,0,1,Y^XZ";
            dos.writeUTF(realDatas) ;
            dos.flush();

          /*  String test = "^XA\n" +
                    "^FO20,20\n" +
                    "^BQ,5,30\n" +
                    "^FDD03040C,LA,博客园的筒子们好^FS\n" +
                    "^XZ\n"
                  ;
            dos.writeUTF(test);
            dos.flush();*/
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static String getDateStr(String produceTime) {
        String format = "";
        try {
            String str = produceTime.replace("T", " ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse(str);
            System.out.println("----" + parse);
            System.out.println(parse.getHours());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            if (parse.getHours() < 8) {
                calendar.set(Calendar.HOUR_OF_DAY, -8);
            }
            format = sdf2.format(calendar.getTime());
            System.out.println(format);
        } catch (Exception e) {

        }

        return format;
    }

    public static void main(String[] args) throws Exception {

        Tcpclient.startServerSocket("10.12.2.222", 9100, new PackageBox());
    }

    public static String scaleZPL(String rawCommands, Double scaleFactor) {
        if (scaleFactor == null) {
            scaleFactor = 300.0 / 203;
        }
        String[] sections = rawCommands.split("\\^");

        // ZPL commands to perform conversion on
        String[] cmds = {"FO", "A0", "A@", "LL", "LH", "GB", "FB", "BY", "B3", "FT"};

        StringBuilder output = new StringBuilder();
        for (String cmd : cmds) {
            for (int j = 0; j < sections.length; j++) {
                if (sections[j].startsWith(cmd)) {
                    sections[j] = scaleSection(cmd, sections[j], scaleFactor);
                }
            }
        }

        return String.join("^", sections);
    }

    /*
     * Scales all integers found in a designated section
     */
    public static String scaleSection(String cmd, String section, double scaleFactor) {
        section = section.substring(cmd.length());
        String[] parts = section.split(",");
        for (int p = 0; p < parts.length; p++) {
            if (isInt(parts[p])) {
                parts[p] = Integer.toString((int) Math.round(scaleFactor * Integer.parseInt(parts[p])));
            }
        }

        return cmd + String.join(",", parts);
    }

    /*
     * Checks if a string is an integer
     */
    public static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}