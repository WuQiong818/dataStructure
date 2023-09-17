package four;

import java.util.Scanner;

public class P5728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        int num = 0;
        int count = 0;//记录旗鼓相当的人数
        for (int i = 0; i < array.length; i++) {//控制最外层 12345.。。n
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (Math.abs(array[i][k] - array[j][k]) <= 5) {
                        sum1 += array[i][k];
                        sum2 += array[j][k];
                        num++;
                    }else{
                        break;
                    }
                }
                if (num == 3 && Math.abs(sum1 - sum2) <= 10) {
                    count++;
                }
                num=0;
                sum1=0;
                sum2=0;
            }

        }
        System.out.println(count);
    }
}
