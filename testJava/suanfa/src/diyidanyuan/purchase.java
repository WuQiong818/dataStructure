package diyidanyuan;

import java.util.Scanner;
public class purchase {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=(a*10+b)/(1*10+9);
        System.out.print(count);
    }
}
