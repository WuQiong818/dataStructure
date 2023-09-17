package four;

import java.util.Scanner;

public class P1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] array = new boolean[n + 1][n + 1];
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] torch = new int[a * 2];
        int[] fluorite = new int[b * 2];
        for (int i = 0; i < torch.length; i++) {
            torch[i] = sc.nextInt();
        }
        for (int i = 0; i < fluorite.length; i++) {
            fluorite[i] = sc.nextInt();
        }
        while (true) {
            int index = 0;
            int start = torch[index];
            int end = torch[index + 1];
            for (int i =start-1;i<end+1;i++){

            }
            index += 2;
            if (index >=torch.length) {
                break;
            }
        }
    }
}
