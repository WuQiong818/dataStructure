package four;

import java.util.Scanner;

public class P1428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < j; k++) {
                if (array[j] > array[k]) {
                    count++;
                }
            }
            System.out.print(count+" ");
            count=0;
        }
    }
}
