package ioStream;

import java.io.*;
import java.util.Arrays;

public class tempTest {
    public static void main(String[] args) {

        try(FileOutputStream fOut = new FileOutputStream("E:/text/temp.txt");
        DataOutputStream dOut = new DataOutputStream(fOut);){
            dOut.writeInt(10);
            dOut.writeLong(12345);
            dOut.writeFloat(3.1415926f);
            dOut.writeDouble(978654321.123);
            dOut.writeBoolean(true);
            dOut.writeChars("Goodbye!");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileInputStream fIn = new FileInputStream("E:/text/temp.txt");
            DataInputStream dIn = new DataInputStream(fIn);){
            /*这里是存在一个读取顺序的问题的。*/
            /*System.out.println(dIn.readInt());
            System.out.println(dIn.readLong());
            System.out.println(dIn.readFloat());
            System.out.println(dIn.readDouble());
            System.out.println(dIn.readBoolean());
            char ch;
            while((ch = dIn.readChar())!='\0'){
                System.out.print(ch);//\0一般用于字符串，表示字符串结束
            }*/
            System.out.println(Arrays.toString(fIn.readAllBytes()));
        }catch (FileNotFoundException e) {
            System.out.println("文件没有找到");
        } catch (IOException e) {
        }
    }
}
