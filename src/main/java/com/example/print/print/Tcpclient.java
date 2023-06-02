package com.example.print.print;

import com.example.print.bean.PackageBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Component
public class Tcpclient {

    //    public static void main(String[] args) {
//        //String hex = Integer.toHexString(var);
//
//        String addressIP="192.168.116.240";
//        int addressPort=9100;
//
//        startServerSocket(addressIP,addressPort);
//    }
    @Autowired
    private App app;

    public  void startServerSocket(String addressIP, int addressPort, PackageBox packageBox) {
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

    public  void sendData(DataOutputStream dos, PackageBox packageBox) {


        try {
            System.out.println("=========================================");



            String product = "POY".equals(packageBox.getProductName()) ? "涤纶预取向丝POY" : "涤纶牵伸丝FDY";

            String qrcode = "^XA^CWZ,E:SIMSUN.TTF^JMA^LL1182^PW1100^MD0^PR3^PON^LRN^LH0,0^CI28^FO449,160^BQN,2,20^FDLA," + packageBox.getProductInfo().get(0).getNewProductCode()
                    +"^FS";
            String print = app.print(qrcode);
            DecimalFormat dataFormat = new DecimalFormat( "0.0");
            print += print +

                    "^PQ1^FO278,180^AZN,106,96^FD" +
                    product
                    + "^FS^FT240,349^A0N,63,56^FH^FD" +
                    packageBox.getSpec() +
                    "^FS^FT240,424^A0N,58,56^FH^FD" +
                    packageBox.getBatchNo() +
                    "^FS^FT240,485^A0N,58,56^FH^FD" +
                    packageBox.getGrade() +
                    "^FS^FT240,560^A0N,58,56^FH^FD" +
                    Integer.valueOf((int) packageBox.getProductInfo().get(0).getSilkCount()) +
                    "^FS^FO226,600^AZN,58,56^FH^FD" +
                    packageBox.getColor() +
                    "^FS^FT240,726^A0N,58,56^FH^FD" +
                    Double.parseDouble(dataFormat.format(packageBox.getProductInfo().get(0).getNetWeight())) + "KG" +
                    "^FS^FT240,807^A0N,58,56^FH^FD" +
                    Double.parseDouble(dataFormat.format(packageBox.getProductInfo().get(0).getGrossWeight())) + "KG" +
                    "^FS^FT240,870^A0N,58,56^FH^FD" +
                    getDateStr(packageBox.getProduceTime()) +
                    "^FS^FT240,950^A0N,58,56^FH^FD" +
                    packageBox.getProductInfo().get(0).getNewProductCode() +
                    "^FS^FO700,783^AZN,60,96^FD"+packageBox.getClassesInfo()+packageBox.getProductInfo().get(0).getNewProductCode().substring(packageBox.getProductInfo().get(0).getNewProductCode().length()-3)+"^FS"+
                    "^PQ1,0,1,Y^XZ";
            dos.writeUTF(print);
//            dos.writeUTF(dataStr111);
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

//        Tcpclient.startServerSocket("10.12.2.222", 9100, new PackageBox());
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
