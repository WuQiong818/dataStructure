package five;

import java.util.Scanner;

public class P1914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = (char) (str.charAt(i)+n);
            while (ch > 'z') {
                ch = (char) (ch-'z'+'a'-1);
            }
            newStr += ch;
        }
        System.out.println(newStr);
    }
}
