package three;

import java.util.Scanner;

public class P1075 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int min=0;

        for (int i =2; i<=n/2;i++){
            if (n%i==0){
                min=i;
                break;
            }
        }
        System.out.println(n/min);
    }
}
