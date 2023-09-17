package dierdanyuan;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Scanner;
public class shuxueti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        switch (count) {
            case 1: {
                System.out.print("I love Luogu!");
            }
            case 2: {
                int acount=10;
                int a =2;
                int uim=4;
                int baWei=acount-a-uim;
                System.out.print(a+uim+";"+baWei);
            }
            case 3: {
                int amount=14;
                int population=4;
                System.out.println(14/4);
                System.out.println(14/4*4);
                System.out.println(14-14/4*4);
            }
            case 4: {
                double a=500;
                double b=3;
                double result=a/b;
//                double result=500/3;//直接使用数字，默认应该是整数类型，所以需要提前声明；
                DecimalFormat df=new DecimalFormat("#.######");
                String  newResult=df.format(result);
                System.out.print(newResult);
            }
            case 5: {
                int s=260+220;
                int v=12+20;
                System.out.print(s/v);
            }
            case 6: {
                System.out.print(Math.sqrt(6*6+9*9));
            }
            case 7: {
                System.out.println(100+10);
                System.out.println(100+10-20);
                System.out.println(100+10-20-90);
            }

            case 8: {
                double PI=3.141593;
                double r=5;
                System.out.println(2*PI*r);
                System.out.println(PI*r*r);
                System.out.println((4/3)*PI*r*r*r);
            }
            case 9: {
                int i;
                for (i=1;((i/2-1)/2-1)/2-1!=1;i++){
                }
                System.out.println(i);
            }
            case 10: {

            }
            case 11: {

            }
            case 12: {

            }
            case 13: {

            }
            case 14: {

            }
            case 15: {


            }
        }
    }
}
