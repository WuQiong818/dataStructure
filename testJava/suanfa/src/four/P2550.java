package four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[7];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        List<Integer> listArray = new ArrayList<>();
        for (int i = 0; i < n * 7; i++) {
            listArray.add(sc.nextInt());
        }
        for (int j = 0; j < arr1.length; j++) {
            for (int k = 0; k < listArray.size(); k++) {
                if (arr1[j] == listArray.get(k)) {
                    listArray.set(j, -1);
                }
            }
        }
        int num = 0;
        int count = 0;
        int index = 0;
        int[] newArray = new int[8];
        for (int m : listArray) {
            if (m == -1) {
                count++;
            }

            if (num % 7 == 0) {
                newArray[count]++;
                count = 0;
            }
            num++;
        }
        for (int mm = newArray.length-1; mm > 0; mm--) {
            System.out.print(newArray[mm]+" ");
        }
    }
}
