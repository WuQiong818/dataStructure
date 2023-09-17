package dierdanyuan;

import java.util.Scanner;

public class eatApple {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        if (number==0||number==1){
            System.out.print("Today, I ate "+number+" apple.");
        }else{
            System.out.print("Today, I ate "+number+" apples.");
        }
    }
}
