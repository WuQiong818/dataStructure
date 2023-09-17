package five;

import java.util.Scanner;

public class P1200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str1 = sc.next();
        int[] array = new int[27];
        int num = 1;
        int numMod = 0;
        int num1 = 1;
        int numMod1 = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = 0; i < str.length(); i++) {//在这里通过匹配，实现运算；
            num *= array[str.charAt(i) - 64];
        }
        numMod = num%47;
        for (int i = 0; i < str1.length(); i++) {//在这里通过匹配，实现运算；
            num1 *= array[str1.charAt(i) - 64];
        }
        numMod1 = num1%47;

        if (numMod==numMod1){
            System.out.println("GO");
        }else{
            System.out.println("STAY");
        }
    }
}
