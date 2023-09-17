package five;

import java.util.Scanner;

public class P1553 {
    public static void main(String[] args) {
        /*
         * 思路分析:
         * 1.先进行整数的反转,测试好，把整数的反转分装成一个方法
         * 2.对小数，分数，百分数进行条件判断，确定好数位，之后调用方法进行反转即可。进行切割,
         * 获取小数点前后的部分数、获取分号前面的部分数
         * */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //这里仅仅进行切割就可以了
        if (str.indexOf('.') != -1) {
            String str1 = str.substring(0, str.indexOf('.'));
            String str2 = str.substring(str.indexOf('.') + 1, str.length());
            System.out.println(returnToZero(str1) + "." + returnToZero(str2));
        } else if (str.indexOf('/') != -1) {
            String str1 = str.substring(0, str.indexOf('/'));
            String str2 = str.substring(str.indexOf('/') + 1, str.length());
            System.out.println(returnToZero(str1) + "/" + returnToZero(str2));
        } else if (str.indexOf('%') != -1) {
            String str1 = str.substring(0, str.indexOf('%'));
            System.out.println(returnToZero(str1) + "%");
        } else {
            System.out.println(returnToZero(str));
        }
    }

    public static String returnToZero(String str) {
        if (str.equals("0")) {
            return str;
        } else {
            //先把0处理了
            //如果零总是出现在最后的位置，就切割
            while (str.lastIndexOf('0') == str.length() - 1) {
                str = str.substring(0, str.lastIndexOf('0'));
            }
            while (str.indexOf('0') == 0) {
                str = str.substring(1, str.length());
            }
            String newStr = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                newStr += str.charAt(i);
            }
            return newStr;
        }
    }
}
