package diyidanyuan;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a > b && a > c) {
            if (b > c) {
                System.out.print(c + "\r");
                System.out.print(b + "\r");
            } else {
                System.out.print(b + "\r");
                System.out.print(c + "\r");
            }
            System.out.print(a + "\r");
        } else if (b > a && b > c) {
            if (c > a) {
                System.out.print(a + "\r");
                System.out.print(c + "\r");
            } else {
                System.out.print(c + "\r");
                System.out.print(a + "\r");
            }
            System.out.print(b + "\r");
        }else {
            if (b > a) {
                System.out.print(a + "\r");
                System.out.print(b + "\r");
            } else {
                System.out.print(b + "\r");
                System.out.print(a + "\r");
            }
            System.out.print(c + "\r");
        }
    }
}
