package five;

import java.util.Scanner;

public class P5015 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str= sc.nextLine();
        int length = str.length();
        for (int i =0 ;i<str.length();i++){
            if (str.charAt(i)==' '){
                length--;
            }
        }
        System.out.println(length);
    }
}
