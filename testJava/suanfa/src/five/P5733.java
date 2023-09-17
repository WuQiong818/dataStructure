package five;

import java.util.Scanner;

public class P5733 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str =sc.next();
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) > 90 &&str.charAt(i)<123){
                String str1 = str.substring(0,i);
                String str2= str.substring(i+1);
                char ch = (char) (str.charAt(i)-32);
                str = str1+ch+str2;
            }
        }
        System.out.println(str);
    }
}
