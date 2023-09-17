package three;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P5726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        int min = 9;
        int max = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            if (temp > max) {
                max = temp;
            } else if (temp<min) {
                min = temp;
            }
            sum+=temp;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        double avg = (sum-min-max)/(n-2);
        System.out.println(String.format("%.2f",avg));
    }
}
