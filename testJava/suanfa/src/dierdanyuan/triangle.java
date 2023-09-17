package dierdanyuan;

import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int longer;
        int short1;
        int short2;
        if (a > b && a > c) {
            longer = a;
            short1 = b;
            short2 = c;
        } else if (b > a && b > c) {
            longer = b;
            short1 = a;
            short2 = c;
        } else {
            longer = c;
            short1 = a;
            short2 = b;
        }

        if (short1 + short2 > longer) {
            if (short1 * short1 + short2 * short2 == longer * longer) {
                System.out.println("Right triangle");
            } else if (short1 * short1 + short2 * short2 > longer * longer) {
                System.out.println("Acute triangle");
            } else {
                System.out.println("Obtuse triangle");
            }
            if (short1==short2){
                System.out.println("Isosceles triangle");
                if (short1==longer){
                    System.out.println("Equilateral triangle");
                }
            }
        } else {
            System.out.println("Not triangle");
        }
    }
}