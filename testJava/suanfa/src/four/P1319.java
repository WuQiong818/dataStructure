package four;

import java.util.Scanner;

public class P1319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int[] record = new int[200];
        int index = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count > n) {
                    break;
                }
                count++;
                if (index % 2 == 0) {
                    array[i][j] = 1;
                    index++;
                }else{
                    array[i][j]=0;
                    index++;
                }
            }

        }
    }
}
