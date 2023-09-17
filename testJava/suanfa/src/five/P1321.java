package five;

import java.util.Arrays;
import java.util.Scanner;

public class P1321 {
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        match();
    }


    //自己的思路错了，考虑不全面，没有考虑到每次粘贴覆盖留下的单词不同的情况;
    public static void match() {
        int a = 0;
        int b = 0;
        for (int j = 0; j < str.length()-2; j++) {
            if (str.charAt(j)=='b'||str.charAt(j+1)=='o'||str.charAt(j+2)=='y') {
                a++;
            }
        }
        for (int j = 0; j < str.length()-3; j++) {
            if (str.charAt(j)=='g'||str.charAt(j+1)=='i'||str.charAt(j+2)=='r'||str.charAt(j+3)=='l') {
                b++;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}
