package five;

import java.util.Scanner;

public class P1125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 97;
            array[n]++;
        }
        int min = 100;
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min && array[i] != 0) {
                min = array[i];
            }
        }
        boolean flag = true;//默认是false,如果是质数，则令其为true;
        int num = max - min;
        if (num <= 1) {
            flag = false;
        } else {
            for (int i = 2; i < num; i++) {//这个二这里怎么处理，难住我了；
                if (num % i == 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("Lucky Word");
            System.out.println(num);
        } else {
            System.out.println("No Answer");
            System.out.println("0");
        }
    }
}
