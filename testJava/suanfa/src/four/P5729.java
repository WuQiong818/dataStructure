package four;

import java.util.Scanner;

public class P5729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int x = sc.nextInt();
        int h = sc.nextInt();
        int[][][] array = new int[w+1][x+1][h+1];//默认赋值为0；
        int q = sc.nextInt();
        int[] record = new int[6*q];
        for (int hh = 0;hh< record.length;hh++){
            record[hh]=sc.nextInt();
        }
        for (int m =0;m<q;m++) {
            for (int i = record[0+(m*6)]; i <= record[3+(m*6)]; i++) {
                for (int j = record[1+(m*6)]; j <= record[4+(m*6)]; j++) {
                    for (int k = record[2+(m*6)]; k <= record[5+(m*6)]; k++) {
                        array[i][j][k] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = 0; k < array[0][0].length; k++) {
                    if (array[i][j][k] == 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println(w*x*h-count);
    }
}