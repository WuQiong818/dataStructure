package three;

import java.util.Scanner;

public class P5956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() / 52;
        int x;
        int k = 0;
        int temp1 = 0;
        int temp2 = 0;
        for (x = 1; x <= 100; x++) {
            if ((n-(x*7)) % 21 == 0) {
                temp1 = x;
                if ((n-(x*7))<=21){
                    break;
                }
            }
        }
        temp2 =(n-temp1*7)/21;
        System.out.println(temp1);
        System.out.println(temp2);

    }
}
