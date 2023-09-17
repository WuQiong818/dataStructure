package five;

import java.util.Scanner;

public class P1765 {
    public static void main(String[] args) {
        char ch = 'a';//32 a=97
        int[] array = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count =0 ;
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i)==' '){
                count+=1;
            }else{
                count+=array[str.charAt(i)-97];
            }
        }
        System.out.println(count);
    }
}
