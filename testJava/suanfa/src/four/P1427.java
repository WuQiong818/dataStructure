package four;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[100];
        int temp = 0;
        while (!sc.hasNext("0")) {
            array[temp] = sc.nextInt();
            temp++;
        }
        for (int j=temp-1;j>=0;j--){
             System.out.print(array[j]+" ");
        }
    }
}
