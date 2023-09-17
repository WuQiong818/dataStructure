package three;

import java.util.Scanner;

public class P1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        double sum = 0;
         int count=0;
        for (double i = 1; sum <= k; i++) {
            sum += 1 / i;
            count++;
        }
        System.out.println(count);
    }
}
