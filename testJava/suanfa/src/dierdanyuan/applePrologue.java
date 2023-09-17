package dierdanyuan;

import java.util.Scanner;

public class applePrologue {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        double t=sc.nextDouble();
        double s=sc.nextDouble();
        if (m-(int)Math.ceil(s/t)<0){
            System.out.println(0);
        }else{
            System.out.println(m-(int)Math.ceil(s/t));
        }
    }
}