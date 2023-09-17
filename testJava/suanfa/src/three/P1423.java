package three;

import java.util.Scanner;

public class P1423 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double target = sc.nextDouble();
        double first=2D;
        double sum=0D;
        int count=0;
        for (int i=0;sum<=target;i++){
            sum+=first*Math.pow(0.98,i);
            count++;
        }
        System.out.println(count);
    }
}
