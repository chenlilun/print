package com.example.print.print;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class SimplePrint {
    private Integer addNum;
    private String addValue;
    /**
     * 读取指令txt文件
     * @return
     * @throws Exception
     */


    public static void main(String[] args) {
        try {
            //每次生成一不同的二维码
            SimplePrint a = new SimplePrint();
            a.setAddNum(0);
            while(true) {
                a.addNum++;
                Thread.sleep(2000);
                System.out.println(a.getAddNum());
                a.AutoAddTag();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  String NumberToString(Integer num) {
        //二维码生成内容例如：‘H100001’（H1不变，H1之后的数依次增长），规则为36进制
        String str = "";
        String cs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] c = cs.toCharArray();
        if (num < (36 * 36 * 36 * 36 * 36)&&num>0)
        {
            while (num >= 36)
            {
                str = c[num%36] + str;
                num = num / 36;
            }
            return c[num] + str;
        }
        else
        {
            addNum = 0;
            addNum ++;
            String intTo36 = NumberToString(getAddNum());
            return intTo36;
        }
    }
    public String addTag(String addValue) {
        StringBuffer str = new StringBuffer();
        if(addValue.length()==1) {
            str.append("0000"+addValue);
        }
        if(addValue.length()==2) {
            str.append("000"+addValue);
        }
        if(addValue.length()==3) {
            str.append("00"+addValue);
        }
        if(addValue.length()==4) {
            str.append("0"+addValue);
        }
        if(addValue.length()==5) {
            str.append(addValue+"");
        }
        return str.toString();
    }
    public void AutoAddTag() throws IOException {
        InputStream in = SimplePrint.class.getResourceAsStream("zpl.txt");
        InputStreamReader read = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(read);
        String string = "";
        StringBuffer buffer = new StringBuffer();
        Integer addNum = getAddNum();
        String codeNum=addTag(NumberToString(addNum));
        while ((string = reader.readLine()) != null) {
            buffer.append(string);
        }
        read.close();
        in.close();
        String context = buffer.substring(34, 39);
        String context1 = buffer.substring(66,73);
        System.out.println(context);
        System.out.println(codeNum);
        System.out.println(context1);

        if(codeNum.equals(context)) {
            buffer.replace(32, 39,"H1"+addTag(NumberToString(addNum+1)));
            buffer.replace(66, 73, "H1"+addTag(NumberToString(addNum+1)));
            System.out.println(buffer);
            setAddValue(buffer.toString());
            String zplOrder = getAddValue();
            String path = SimplePrint.class.getResource("zpl.txt").getPath();
            Writer w = new FileWriter(path);
            w.write(zplOrder);
            w.flush();
            w.close();
        }else {
            System.out.println("生成失败");
        }
    }

    //打印机调用方法
    public void print(String str) throws PrintException {

        PrintService psZebra = PrintServiceLookup.lookupDefaultPrintService();
        if (psZebra == null) {
            return;
        }
        DocPrintJob job = psZebra.createPrintJob();
        byte[] by = str.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        Doc doc = new SimpleDoc(by, flavor, null);

        job.print(doc, null);
    }


    public String getAddValue() {
        return addValue;
    }
    public void setAddValue(String addValue) {
        this.addValue = addValue;
    }
    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {

        this.addNum = addNum;
    }

}
