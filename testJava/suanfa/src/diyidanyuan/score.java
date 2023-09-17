package diyidanyuan;

import java.util.Scanner;

public class score {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int score=(int)(A*0.2+B*0.3+C*0.5);
        System.out.print(score);
    }
}
