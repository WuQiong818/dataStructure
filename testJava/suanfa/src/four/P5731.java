package four;

import java.util.Scanner;

public class P5731 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int index = 0;
        int x = 0;
        int y = 0;
        while (index <= n * n) {
            while (array[x][y + 1] == 0 && y < array.length) array[x][++y] = ++index;
            while (array[x + 1][y] == 0 && x < array.length) array[++x][y] = ++index;
            while (array[x][y - 1] == 0 && y > 1) array[x][y--] = ++index;
            while (array[x - 1][y] == 0 && x > 1) array[x--][y] = ++index;
        }
        System.out.println(array);

    }
}
