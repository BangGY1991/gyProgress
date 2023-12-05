package com.example.demo;


import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64Demo{

    public static void main(String[] args) {
        String imagePath = "F:\\yonyou\\客户.png";
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imagePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码过的字节数组字符串
        System.out.println(encoder.encode(data));
        //return "data:image/png;base64," + encoder.encode(data)
//        String base64String = convertImageToBase64(imagePath);
//        System.out.println(base64String);

    }


//    public static String convertImageToBase64(String imagePath) {
//        File imageFile = new File(imagePath);
//        try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
//            // 读取图片文件内容
//            byte[] imageData = new byte[(int) imageFile.length()];
//            fileInputStream.read(imageData);
//
//            // 将图片字节数组编码为Base64字符串
//            return Base64Demo.getEncoder().encodeToString(imageData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
}
