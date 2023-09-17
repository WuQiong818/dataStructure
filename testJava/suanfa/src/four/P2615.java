package four;

import java.util.Arrays;
import java.util.Scanner;
public class P2615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        array[0][n / 2] = 1;
        int row = 0;//hang
        int col = 0;//lie
        for (int i = 2; i <= n * n; i++) {
            row = isSame(array, i - 1)[0];
            col = isSame(array, i - 1)[1];
            if (row == 0 && col != n - 1) {
                array[n - 1][col + 1] = i;
            } else if (row != 0 && col == n - 1) {
                array[row - 1][0] = i;
            } else if (row == 0 && col == n - 1) {
                array[row + 1][col] = i;
            } else {
                if (row != 0 && col != n - 1 && array[row - 1][col + 1] == 0) {
                    array[row - 1][col + 1] = i;
                } else {
                    array[row + 1][col] = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static int[] isSame(int[][] array, int num) {
        int[] newArray = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == num) {
                    newArray[0] = i;
                    newArray[1] = j;
                    i = array.length;
                    break;
                }
            }
        }
        return newArray;
    }
}
