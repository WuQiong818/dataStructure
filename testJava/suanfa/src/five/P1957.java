package five;

import java.util.Scanner;

public class P1957 {
    /*
    *符号的记录，很关键
    *
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str="";
        char ch = ' ';//
        char oper = ' ';//运算符
        for (int i = 0; i < n; i++) {
            String condition = sc.next();
            if (condition.equals("a")||condition.equals("b")||condition.equals("c")) {//如果是abcd的话
                ch =condition.charAt(0);
                int a = sc.nextInt();
                int b = sc.nextInt();
                oper = transform(ch);
                int result = cal(a,ch,b);
                str = a+""+oper+""+b+"="+result;
            }else {
                int a =Integer.parseInt(condition);
                int b =sc.nextInt();
                int result = cal(a,ch,b);
                str = a+""+oper+""+b+"="+result;
            }
            System.out.println(str);
            System.out.println(str.length());
        }
    }

    public static char transform(char ch) {
        if (ch == 'a') {
            return '+' ;
        } else if (ch == 'b') {
            return '-';
        } else {
            return '*';
        }
    }
    public static int cal(int a , char ch, int b){
        if (ch == 'a') {
            return a+b ;
        } else if (ch == 'b') {
            return a-b;
        } else {
            return a*b;
        }
    }
}
