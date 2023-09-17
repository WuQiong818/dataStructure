package four;

import java.util.Scanner;

public class P5732 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        array[0][0] = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == 0) {
                    array[i][j] = array[i - 1][j];
                } else {
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j]!=0){
                    System.out.print(array[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
}
