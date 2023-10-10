package ioStream;

import java.io.*;

/*
* 需求，创建一个文本文件myfile.txt，写入从键盘输入的一串字符，然后再读取该文件并将文本内容显示到屏幕上
* 1.使用FileOutputStream(File file)创建一个文件对象file的输出流
*
* */
public class myFileTest {
    public static void main(String[] args) {
        char ch;
        int data;
        try( FileInputStream fileIn = new FileInputStream(FileDescriptor.in);
             FileOutputStream fileOut = new FileOutputStream("E:/text/myfile.txt");){
            System.out.println("请输入一串字符，并以 # 结束:");
            while((ch = (char) fileIn.read())!='#'){
                fileOut.write(ch);
            }
        }catch(FileNotFoundException e){
            System.out.println("文件没有找到");
        }catch (IOException e) {
            System.out.println("io错误");
        }


        try(FileInputStream fileIn = new FileInputStream("E:/text/myfile.txt");
        FileOutputStream fileOut = new FileOutputStream(FileDescriptor.out);){
            while(fileIn.available()>0){
                data = fileIn.read();
                fileOut.write(data);
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
