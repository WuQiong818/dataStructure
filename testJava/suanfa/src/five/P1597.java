package five;

import java.util.Scanner;

public class P1597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strArray = str.split(";");
        for (String str1 : strArray) {
            int index = str1.indexOf("=");
            if (index == str1.length() - 1) {
                System.out.print(0 + " ");
            } else {
                System.out.print(str1.charAt(index + 1) + " ");
            }
        }
    }
}
// (str1.charAt(index+1)>47&&str1.charAt(index+1)<58)