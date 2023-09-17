package dierdanyuan;

import java.util.Scanner;

public class weekend {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        int n=sc.nextInt();
        int dayNum;
        if (x<=6){
            dayNum=n-(x+n-1)/7*2;
            System.out.print(dayNum*250);
        }else{
            dayNum=n-(x+n-1)/7*2+1;
            System.out.print(dayNum*250);
        }
    }
}
