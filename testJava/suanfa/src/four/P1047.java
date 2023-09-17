package four;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roadLong = sc.nextInt();
        int amount = sc.nextInt();
        int[][] array = new int[amount][2];
        for (int i = 0; i < amount; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        int start = 0;
        int area = roadLong+1;
        boolean[] judgement = new boolean[roadLong + 1];
        for (int j = 0; j < array.length; j++) {
            for (start = array[j][0];start<=array[j][1];start++){
                if (!judgement[start]){
                    judgement[start]=true;
                    area--;
                }

            }
        }
        System.out.println(area);
    }
}

























/*public class P1047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int M = in.nextInt();
        int count = L + 1;
        int[] a = new int[M + 5];
        int[] b = new int[M + 5];
        boolean[] c = new boolean[L + 5];
        for (int i = 0; i < M; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            for (int j = a[i]; j <= b[i]; j++) {
                if (c[j] == false) {
                    c[j] = true;
                    count--;
                }
            }
        }
        System.out.println(count);
    }
}*/
