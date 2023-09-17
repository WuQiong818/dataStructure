package three;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char x = sc.next().charAt(0);
        long count = 0;
        String str;
        for (int i = 1; i <= n; i++) {
            str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == x) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
