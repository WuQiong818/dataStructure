package five;

import java.util.Scanner;

public class P1589 {
    //表打斜了
    public static void main(String[] args) {
        int[] array = new int[27];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch > 64 && ch < 91) {
                    array[ch - 64]++;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //这里开始打印，
        for (int i = max; i > 0; i--) {
            for (int j = 1; j < array.length; j++) {
                if (i == array[j]) {
                    System.out.print("* ");
                    array[j]--;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
//            for (int j = 1; j < array.length; j++) {
//                System.out.print(array[j]+" ");
//            }
        }
        System.out.print("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
    }
}
