package five;

import java.util.Scanner;

public class P5734 {
    public static Scanner sc = new Scanner(System.in);
    public static String str;

    public static void main(String[] args) {
        int n = sc.nextInt();
        str = sc.next();//初始字符，即我们的文本
        for (int i = 0; i < n; i++) {
            String condition = sc.next();
            switch (condition) {
                case "1":
                    insert();
                    break;
                case "2":
                    cutDown();
                    break;
                case "3":
                    insertByIndex();
                    break;
                case "4":
                    search();
                    break;
            }
        }
    }

    private static void search() {
        String newStr = sc.next();
        boolean flag = false;
        int count = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == newStr.charAt(0)) {
                for (int j = 0; j < newStr.length(); j++) {
                    if (str.charAt(i + j) == newStr.charAt(0 + j)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count = i;
                break;
            }
        }
        System.out.println(count);
    }

    private static void insertByIndex() {
        int a = sc.nextInt();
        String newStr = sc.next();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {//将原先的str,在a的位置一分为二，后面进行拼接
            if (i < a) {
                str1 += str.charAt(i);
            } else {
                str2 += str.charAt(i);
            }
        }
        str = str1 + newStr + str2;
        System.out.println(str);
    }

    private static void cutDown() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        String newStr = "";
        for (int i = 0; i < b; i++) {
            newStr += str.charAt(i + a);
        }
        str = newStr;
        System.out.println(str);
    }

    private static void insert() {
        String newStr = sc.next();
        str += newStr;
        System.out.println(str);
    }
}
