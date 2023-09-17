package three;

import java.util.Scanner;

public class P5725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
                if (count < 10) {
                    System.out.print("0" + count);
                } else {
                    System.out.print(count);
                }
            }
            System.out.println("");
        }

        count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (y + x >= n - 1) {//5
                    count++;
                    if (count < 10) {
                        System.out.print("0" + count);
                    }else{
                        System.out.print(count);
                    }
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("  ");
        }

    }
}
