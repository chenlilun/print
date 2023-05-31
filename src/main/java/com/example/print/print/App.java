/*
 * This Java source file was generated by the Gradle 'init' task.
 * 放大处理流程
 * 先直接放大300/203            zpldata1
 * 放大二维码，如果bq指令第二个参数大于10，只能转成图片形式
 * 如果代码里面已经有gfa代码，还需要放大gfa里面的图像
 * 将生成后的gfa代码替换到原内容里面  zpldata2
 * 最后将以上数据输出
 *
 */

package com.example.print.print;

import java.util.regex.*;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;

import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Component;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import java.util.zip.Deflater;
@Component
public class App {

    private static final int[] CRC_TABLE = {
            0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50a5,
            0x60c6, 0x70e7, 0x8108, 0x9129, 0xa14a, 0xb16b,
            0xc18c, 0xd1ad, 0xe1ce, 0xf1ef, 0x1231, 0x0210,
            0x3273, 0x2252, 0x52b5, 0x4294, 0x72f7, 0x62d6,
            0x9339, 0x8318, 0xb37b, 0xa35a, 0xd3bd, 0xc39c,
            0xf3ff, 0xe3de, 0x2462, 0x3443, 0x0420, 0x1401,
            0x64e6, 0x74c7, 0x44a4, 0x5485, 0xa56a, 0xb54b,
            0x8528, 0x9509, 0xe5ee, 0xf5cf, 0xc5ac, 0xd58d,
            0x3653, 0x2672, 0x1611, 0x0630, 0x76d7, 0x66f6,
            0x5695, 0x46b4, 0xb75b, 0xa77a, 0x9719, 0x8738,
            0xf7df, 0xe7fe, 0xd79d, 0xc7bc, 0x48c4, 0x58e5,
            0x6886, 0x78a7, 0x0840, 0x1861, 0x2802, 0x3823,
            0xc9cc, 0xd9ed, 0xe98e, 0xf9af, 0x8948, 0x9969,
            0xa90a, 0xb92b, 0x5af5, 0x4ad4, 0x7ab7, 0x6a96,
            0x1a71, 0x0a50, 0x3a33, 0x2a12, 0xdbfd, 0xcbdc,
            0xfbbf, 0xeb9e, 0x9b79, 0x8b58, 0xbb3b, 0xab1a,
            0x6ca6, 0x7c87, 0x4ce4, 0x5cc5, 0x2c22, 0x3c03,
            0x0c60, 0x1c41, 0xedae, 0xfd8f, 0xcdec, 0xddcd,
            0xad2a, 0xbd0b, 0x8d68, 0x9d49, 0x7e97, 0x6eb6,
            0x5ed5, 0x4ef4, 0x3e13, 0x2e32, 0x1e51, 0x0e70,
            0xff9f, 0xefbe, 0xdfdd, 0xcffc, 0xbf1b, 0xaf3a,
            0x9f59, 0x8f78, 0x9188, 0x81a9, 0xb1ca, 0xa1eb,
            0xd10c, 0xc12d, 0xf14e, 0xe16f, 0x1080, 0x00a1,
            0x30c2, 0x20e3, 0x5004, 0x4025, 0x7046, 0x6067,
            0x83b9, 0x9398, 0xa3fb, 0xb3da, 0xc33d, 0xd31c,
            0xe37f, 0xf35e, 0x02b1, 0x1290, 0x22f3, 0x32d2,
            0x4235, 0x5214, 0x6277, 0x7256, 0xb5ea, 0xa5cb,
            0x95a8, 0x8589, 0xf56e, 0xe54f, 0xd52c, 0xc50d,
            0x34e2, 0x24c3, 0x14a0, 0x0481, 0x7466, 0x6447,
            0x5424, 0x4405, 0xa7db, 0xb7fa, 0x8799, 0x97b8,
            0xe75f, 0xf77e, 0xc71d, 0xd73c, 0x26d3, 0x36f2,
            0x0691, 0x16b0, 0x6657, 0x7676, 0x4615, 0x5634,
            0xd94c, 0xc96d, 0xf90e, 0xe92f, 0x99c8, 0x89e9,
            0xb98a, 0xa9ab, 0x5844, 0x4865, 0x7806, 0x6827,
            0x18c0, 0x08e1, 0x3882, 0x28a3, 0xcb7d, 0xdb5c,
            0xeb3f, 0xfb1e, 0x8bf9, 0x9bd8, 0xabbb, 0xbb9a,
            0x4a75, 0x5a54, 0x6a37, 0x7a16, 0x0af1, 0x1ad0,
            0x2ab3, 0x3a92, 0xfd2e, 0xed0f, 0xdd6c, 0xcd4d,
            0xbdaa, 0xad8b, 0x9de8, 0x8dc9, 0x7c26, 0x6c07,
            0x5c64, 0x4c45, 0x3ca2, 0x2c83, 0x1ce0, 0x0cc1,
            0xef1f, 0xff3e, 0xcf5d, 0xdf7c, 0xaf9b, 0xbfba,
            0x8fd9, 0x9ff8, 0x6e17, 0x7e36, 0x4e55, 0x5e74,
            0x2e93, 0x3eb2, 0x0ed1, 0x1ef0
    };

    public static String crc16(String s) {
        int crc = 0;

        for (char c : s.toCharArray()) {
            if (c > 255) {
                throw new IllegalArgumentException("RangeError");
            }
            int j = (c ^ (crc >> 8)) & 0xFF;
            crc = CRC_TABLE[j] ^ (crc << 8);
        }

        crc = crc & 0xFFFF;
        String crcHex = String.format("%04x", crc);
        return crcHex;
    }

    public static BufferedImage generateQRCode(String data, int width, int height, String filePath) {
        try {
            // 设置二维码的参数
            com.google.zxing.Writer writer = new MultiFormatWriter();
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);

            // 创建一个空白的 BufferedImage 对象
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // 将 BitMatrix 填充到 BufferedImage 对象中
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }

            //
            // 保存生成的二维码图像到文件
//            File outputFile = new File(filePath);
//            ImageIO.write(image, "png", outputFile);

            System.out.println("二维码生成成功！");
            return image;
        } catch (WriterException e) {
            System.out.println("二维码生成失败：" + e);
            return null;
        }

    }

    public String print(String str){
        String dataStr =str;
        String zpldata = scaleZPL(dataStr, null);

        // 处理GFA指令 未实现，本项目用不到
        zpldata = scaleGfa(zpldata);
        // 处理BQ指令
        zpldata = ProcessZplBqCom(zpldata);
        // 打印完整的zpl指令
        System.out.println(zpldata);
        return  zpldata ;
    }

    public static void main(String[] args) {
        // FileProcessor.filegen();
        for (int j = 0; j < 30; j++) {
            // String dataStr = "^XA" +
            //         "^CWZ,E:SimHei.TTF" +
            //         "^JMA^LL800^PW1100^MD0^PR3^PON^LRN^LH0,0" +
            //         "^CI28" +
            //         "^FO480,200" +
            //         "^BQN,2,10" +
            //         "^FDLA,A20230419AHA02109111C11212121233344068^FS" +
            //         "^PQ1" +
            //         "^FO188,140^AZN,72,72^FD涤纶预取向丝POY^FS" +
            //         "^FT148,236^A0N,39,38^FH^FD250dex/25f^FS" +
            //         "^FT148,287^A0N,39,38^FH^FDXC5555400CD^FS" +
            //         "^FT148,343^A0N,39,38^FH^FDAAA^FS" +
            //         "^FT148,393^A0N,39,38^FH^FD99^FS" +
            //         "^FO112,410^AZN,48,48^FD黄蓝条^FS" +
            //         "^FT148,491^A0N,39,38^FH^FD720.23KG^FS" +
            //         "^FT148,546^A0N,39,38^FH^FD726.23KG^FS" +
            //         "^FT148,598^A0N,39,38^FH^FD2022-12-23^FS" +
            //         "^FT148,650^A0N,39,38^FH^FDA201015XD020701DZ2B201^FS" +
            //         "^FO462,530^AZN,72,72^FD甲001^FS" +
            //         "^PQ1,0,1,Y^XZ";

            // // 初步转化
//        String zpldata = scaleZPL(dataStr, null);

//        // 处理GFA指令 未实现，本项目用不到
//        zpldata = scaleGfa(zpldata);
//        // 处理BQ指令
//        zpldata = ProcessZplBqCom(zpldata);
//        // 打印完整的zpl指令
//        System.out.println(zpldata);
//        PostExample.postdata(zpldata);
        }
    }

    public static String scaleZPL(String rawCommands, Double scaleFactor) {
        if (scaleFactor == null) {
            scaleFactor = 300.0 / 203;
        }
        String[] sections = rawCommands.split("\\^");

        // ZPL commands to perform conversion on
        String[] cmds = { "FO", "A0", "A@", "LL","PW", "LH", "GB", "FB", "BY", "B3", "FT", "AZ" };

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

    public static String ProcessZplBqCom(String zpldata) {

        // 获取qrcode的内容
        String qrcodeContent = getQrcodeContent(zpldata);

        // 获取qrcode的尺寸
        int qrcodeSize = getQrcodeSize(zpldata);
        qrcodeSize = Math.round(qrcodeSize * 300 / 203);

        // 获取qrcode的单元宽度
        // 如果单元宽度widthx*1.5 >10
        // 转为图片生成GFA指令，写入指令中

        if (qrcodeSize > 10) {

            String NewQrGFA = CreateQRGfa(qrcodeContent, qrcodeSize);
            // replace qrcontentcode with GFA command
            zpldata = repBqtoGfa(zpldata, NewQrGFA);

        } else {
            zpldata = scaleQR(zpldata, qrcodeSize);
        }

        return zpldata;

    }

    // 读取文件
    public static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // 获取qrcode的内容
    public static String getQrcodeContent(String zplContent) {
        String qrcodeContent = "";
        String regex = "\\^FDLA,(.*?)\\^FS";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zplContent);
        if (matcher.find()) {
            qrcodeContent = matcher.group(1);
        }

        return qrcodeContent;
    }

    // 获取qrcode的尺寸
    public static int getQrcodeSize(String zplContent) {
        int qrcodeSize = 0;
        Pattern pattern = Pattern.compile("\\^BQN,2,(\\d+)");
        Matcher matcher = pattern.matcher(zplContent);
        if (matcher.find()) {
            qrcodeSize = Integer.parseInt(matcher.group(1));
        }
        return qrcodeSize;
    }

    public static String CreateQRGfa(String qrcodeContent, int qrsize) {

        // double qrcodesize = qrsize * 300/203 * 25 / 300;
        // 获取条码英寸
        int qrcodesizepx = qrsize * 21;
        String qrfile = qrcodeContent + ".png";
        BufferedImage image = generateQRCode(qrcodeContent, qrcodesizepx, qrcodesizepx, qrfile);
        String gfaComand = processImage(image);
        return gfaComand;

    }

    public static String processImage(BufferedImage image) {
        image = invert(image);
        int[] newSize = new int[] { (int) (image.getWidth()), (int) (image.getHeight()) };
        BufferedImage resizedImage = new BufferedImage(newSize[0], newSize[1], BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.drawImage(image, 0, 0, newSize[0], newSize[1], null);
        g.dispose();

        // Convert the image back to a binary array
        byte[] resizedImageData = ((DataBufferByte) resizedImage.getRaster().getDataBuffer()).getData();

        // Compress the data and encode it in base64
        Deflater deflater = new Deflater();
        deflater.setInput(resizedImageData);
        deflater.finish();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            baos.write(buffer, 0, count);
        }
        byte[] compressedData = baos.toByteArray();
        String encodedData = Base64.getEncoder().encodeToString(compressedData);

        String crc = crc16(encodedData);

        // Calculate the new bytes per row and total rows
        int bytesPerRow = (int) Math.ceil(newSize[0] / 8.0);
        int totalRows = newSize[1];

        // Create the ^GFA command
        // String gfaCommand = String.format("^GFA,%d,%d,%d,:Z64:%s:%s", totalRows *
        // bytesPerRow, totalRows,
        // bytesPerRow, encodedData, crc);
        String gfaCommand = String.format("^GFA,%d,%d,%d,:Z64:%s:%s", totalRows * bytesPerRow, totalRows * bytesPerRow,
                bytesPerRow, encodedData, crc);

        return gfaCommand;
    }

    // 反白图像
    public static BufferedImage invert(BufferedImage image) {
        if (image.getType() != BufferedImage.TYPE_INT_ARGB) {
            image = convertToARGB(image);
        }

        LookupTable lookup = new LookupTable(0, 4) {
            @Override
            public int[] lookupPixel(int[] src, int[] dest) {
                dest[0] = (int) (255 - src[0]);
                dest[1] = (int) (255 - src[1]);
                dest[2] = (int) (255 - src[2]);
                return dest;
            }
        };
        LookupOp op = new LookupOp(lookup, new RenderingHints(null));
        return op.filter(image, null);
    }

    private static BufferedImage convertToARGB(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public static String repBqtoGfa(String zpldata, String replString) {
        // 查找^FO480,200" +
        // "^BQN,2,10" +
        // "^FDLA,A20230419AHA02109111C068^FS"
        // 将^BQ指令替换成GFA指令
        String output = zpldata.replaceAll("\\^BQN.*?\\^FS", replString);
        return output;
    }

    public static String scaleQR(String zpldata, int qrcodeSize) {
        String repstr = "^BQN,2," + String.valueOf(qrcodeSize) + "^";
        zpldata = zpldata.replaceAll("\\^BQN.*?\\^", repstr);
        return zpldata;
    }

    // 现在代码暂时用不着
    // 主要针对代码里面有GFA命令的
    // 先获取gfa数据，将gfa数据转换为图片
    // 将图片放大
    // 将处理好的图片再转为GFA命令，写回原指令
    public static String scaleGfa(String zpldata) {

        // 查找GFA命令

        return zpldata;
    }

}
