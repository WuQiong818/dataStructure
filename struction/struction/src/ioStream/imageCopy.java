package ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class imageCopy {
    public static void main(String[] args) {

        try(FileInputStream fi = new FileInputStream("C:/Users/wang'ye/OneDrive/图片/本机照片/taishan.jpg");
        FileOutputStream fo = new FileOutputStream("E:/text/风景1.jpg");){
            System.out.println("照片的长度"+fi.available());
            byte[] b = new byte[fi.available()];
            fi.read(b);
            fo.write(b);
            System.out.println("任务完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
