package com.example.print.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Tcpclient {

    public static void main(String[] args) {
        //String hex = Integer.toHexString(var);

        String addressIP="192.168.116.240";
        int addressPort=9100;

        startServerSocket(addressIP,addressPort);
    }

    public static void startServerSocket(String addressIP,int addressPort) {
        try {
            //serverSocket = new ServerSocket(addressPort);
            Socket acceptSocket = new Socket(addressIP,addressPort);

            DataInputStream dis = new DataInputStream(acceptSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(acceptSocket.getOutputStream());

            while(true) {
                //boolean isClosed = isServerClose(acceptSocket);//判断是否断开

                boolean isClosed = acceptSocket.isClosed();

                    //InetAddress spcketAddress = acceptSocket.getInetAddress();
                    //String hostName = spcketAddress.getHostAddress();
                    //String receiveMsg = dis.readUTF();

                    //System.out.println("host name:"+hostName+"  msg:"+receiveMsg);
                    for (int i = 0; i < 1; i++) {
						sendData(dos);
					}
					break;//这里如果不中断会一直打印


            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public static void sendData(DataOutputStream dos) {
//        String dataStr = "^XA^CW1,E:SIMSUN.TTF^CI28^FO50,60^A1N,20,20^FD简体中文abcd1234^FS^FO50,160^A1N,30,30^FD简体中文abcd1234^FS^FO50,260^A1N,50,50^FD简体说的那么，电脑什么，是你的什么都能，动漫吗，说的那么， 那是多么，你吗，十多年吗，是你的吗，那是多么，你的生命，你是，大美女什么，等你什么，的 中文abcd1234^FS^XZ";
        String dataStr = "\u0010CT~~CD,~CC^~CT~\n" +
                "^XA~TA000~JSN^LT0^MNW^MTT^PON^PMN^LH0,0^JMA^PR6,6~SD15^JUS^LRN^CI0^XZ\n" +
                "^XA\n" +
                "^MMT\n" +
                "^PW799\n" +
                "^LL0799\n" +
                "^LS0\n" +
                "^FO128,64^GFA,18432,18432,00048,:Z64:\n" +
                "eJzt17sOwjAMheFsef+39VYkwLcQyoRED/+ZmvpzNsvtGIQQQn4086ixONu9Zk9jeLyo3z/7XRZ3nvfi8Vf1fp5R7WpGDY9X995RTz4teLy6zzdHmZizfYHHX9l7cl+kHOUWPF7P11ibjKMZPF7Pv2ZGn6v51uLx1/Z9XvKrKfvqDOHxar5vh/q30O80PF7S+zlnx2dkxvxMPF7SP+p9MvrUZBcer+bd+s6om2N9h8dr+X0+1fF4De9bYd0NdWN4DY/X83Vf9BnZ1fB4Nf/6l7Cv4fH63mI68Ph/82PpwuPVvcfrvWs0h8dr+Zp1X/QaHq/mCSFfyg02seSl:832D\n" +
                "^FT130,699^A0B,28,28^FH\\^FD270px/dex^FS\n" +
                "^FT185,699^A0B,28,28^FH\\^FDXC2700356^FS\n" +
                "^FT234,699^A0B,28,28^FH\\^FDAAA^FS\n" +
                "^FT278,699^A0B,28,28^FH\\^FD99^FS\n" +
                "^FT324,699^A0B,28,28^FH\\^FD???^FS\n" +
                "^FT372,699^A0B,28,28^FH\\^FD720kg^FS\n" +
                "^FT447,699^A0B,28,28^FH\\^FD721.2kg^FS\n" +
                "^FT509,699^A0B,28,28^FH\\^FD2022-11-09^FS\n" +
                "^FT582,699^A0B,28,28^FH\\^FDM2205225PC45445PJAU0001^FS\n" +
                "^PQ1,0,1,Y^XZ";
        try {
            System.out.println("=========================================");
            System.out.println(dataStr);

            dos.writeUTF(dataStr);
            //dos.write(dataStr.getBytes());
            //dos.writeBytes(dataStr);

            //byte[] bytes1 = new byte[dataStr.length()];
            /*for(int i=0;i<dataStr.length();i++) {
                //bytes1[i] = dataStr.ge
            }*/
            //dos.writeBytes(dataStr);
            dos.flush();

            //byte[] bytes = new byte[2400];
            //dos.write(dataStr.getBytes());
            //dos.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}




