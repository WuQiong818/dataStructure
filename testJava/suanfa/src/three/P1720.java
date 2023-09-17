package three;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P1720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sqrt=Math.sqrt(5);
        double cost=0d;
        for (int i=1;i<=n;i++){
            cost=(Math.pow((1+sqrt)/2,i)-Math.pow((1-sqrt)/2,i))/sqrt;
        }
        String result =String.format("%.2f",cost);
        System.out.println(result);
    }
}