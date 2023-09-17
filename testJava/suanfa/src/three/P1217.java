package three;

import java.util.Scanner;

public class P1217 {
    /*
     * 方法一：
     * 1.先用字符创判断是否是回文数；
     * 之后再进行质数的判断
     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean flag = false;
        if (start%2==0){start+=1;}
        for (int i = start; i <= end; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j <= str.length() / 2; j++) {
                if (str.charAt(j) == str.charAt(str.length() - j - 1)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int paliNum = Integer.parseInt(str);
                boolean isPrime = false;
                if (paliNum ==2) {
                    isPrime = true;
                };
                for (int k = 2; k < paliNum; k++) {
                    if (paliNum % k == 0) {
                        isPrime = false;
                        break;
                    } else {
                        isPrime = true;
                    }
                }
                if (isPrime)
                    System.out.println(paliNum);
            }
        }
    }
}
