package dierdanyuan;

import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        int tump;
        for (int i = 0; i < 3; i++) {
            array[i] = sc.nextInt();
        }
        String str = sc.next();
        for (int j = 0; j < array.length - 1; j++) {
            for (int k = 0; k < array.length - j - 1; k++) {
                if (array[k] > array[k + 1]) {
                    tump = array[k + 1];
                    array[k + 1] = array[k];
                    array[k] = tump;
                }
            }
        }
//        if (str.equals("ABC")){
//            str="012";
//        }else if (str.equals("ACB")){
//            str="021";
//        }else if (str.equals("BAC")){
//            str="102";
//        }else if (str.equals("BCA")){
//            str="120";
//        }else if (str.equals("CAB")){
//            str="201";
//        }else{
//            str="210";
//        }
        String str1;
        String str2;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                int index = str.indexOf('A');
                if (index == 0) {
                    str1="";
                } else {
                    str1 = str.substring(0, index);
                }
                str2 = str.substring(index + 1, str.length());
                str = str1 + "0" + str2;
            } else if (str.charAt(i) == 'B') {
                int index = str.indexOf('B');
                if (index == 0) {
                    str1="";
                } else {
                    str1 = str.substring(0, index);
                }
                str2 = str.substring(index + 1,str.length());
                str = str1 + "1" + str2;
            } else {
                int index = str.indexOf('C');
                if (index == 0) {
                    str1="";
                } else {
                    str1 = str.substring(0, index);
                }
                str2 = str.substring(index + 1, str.length());
                str = str1 + "2" + str2;
            }
        }
        System.out.println(str);
        System.out.print(array[str.charAt(0) - 48] + " " + array[str.charAt(1) - 48] + " " + array[str.charAt(2) - 48]);
    }
}
