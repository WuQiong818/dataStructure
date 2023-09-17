package three;

import java.util.Scanner;

public class P5723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long sum = 0;
        boolean flag=true;
        int count=0;
        for (int i = 2; sum + i <= l; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }

            }
            if (flag) {
                System.out.println(i);
                sum+=i;
                count++;
            }

        }
        System.out.println(count);
    }
}