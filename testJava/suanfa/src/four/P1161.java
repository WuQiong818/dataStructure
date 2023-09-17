package four;

import java.util.Scanner;

public class P1161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //使用异或运算符，进行求解
        int sum = 0 ;
        while(n>0){
            double a = sc.nextDouble();
            int b = sc.nextInt();
            for (int i=1;i<=b;i++){
                sum ^=(int)(a*i);//括号一定要注意哈，这里不加括号的话，仅仅只对a进行转型
            }
            n--;
        }
        System.out.println(sum);
    }
}
        /*boolean[] array = new boolean[2000000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] num1 = new double[n * 2];
        for (int i = 0; i < n * 2; i++) {
            num1[i] = sc.nextDouble();
        }
        for (int i = 0; i < n * 2; i++) {
            double a = num1[i];
            double b = num1[++i];
            for (int j = 1; j <= b; j++) {
                if (array[(int) (a * j)]) {
                    array[(int) (a * j)] = false;
                } else {
                    array[(int) (a * j)] = true;
                }
            }
        }
        for (int i = 0; i < 2000000; i++) {
            if (array[i]) {
                System.out.println(i);
                break;
            }
        }*/
