package three;

import java.io.IOException;
import java.util.Scanner;

public class P1307 {
   /* public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        String str = Long.toString(N);
        String newStr = "";
        int strLong = str.length();
        for (int i = 1; i <= strLong; i++) {
            if (str.charAt(strLong - i) == '0') {
                str = str.substring(0, str.length() - 1);
            } else {
                break;
            }
        }
        if (str.charAt(0) == '-') {
            newStr="-";
            for (int i = 0; i < str.length() - 1; i++) {
                newStr += str.charAt(str.length()-1-i);
            }
        } else {
            for (int i = 0; i < str.length() - 1; i++) {
                newStr += str.charAt(str.length()-1-i);
            }
        }
        System.out.println(newStr);


    }*/

/*   这才是算法，逻辑清晰，结构明确，代码简洁；
学到的点：String reverse() 字符串反转
反转之后，将数据转化为Integer类型，直接消除前面的0;

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String x = String.valueOf(N);
        StringBuilder y = new StringBuilder(x); //使用System.Text.StringBuilder类,可以修改字符串而不创建新的对象
        if (N == 0) {  //当输入的整数为0时，输出0
            Integer a = Integer.valueOf(x);
            System.out.println(a);
        } else if (N < 0) {  //当输入的整数为负数时，利用reverse()方法进行反转
            y.reverse(); //进行反转
            x = y.substring(0, y.length() - 1); //提取字符串中介于两个指定下标之间的字符。
            Integer b = Integer.valueOf(x); //将字符串类型转化为int输出
            System.out.println("-" + b);
        } else {  //当输入的整数为正数时，利用reverse()方法进行反转
            y.reverse();
            Integer c = Integer.valueOf(y.toString());
            System.out.println(c);
        }
    }*/
}
