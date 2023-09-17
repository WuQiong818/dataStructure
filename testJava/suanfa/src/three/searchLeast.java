package three;

import java.util.ArrayList;
import java.util.Scanner;

public class searchLeast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 12; i++) {
            myList.add(sc.nextInt());
        }
        int result = 0;
        int save = 0;
        int remain = 0;
        boolean flag = true;
        for (int k = 0; k < 12; k++) {
            remain = 300 - myList.get(k);
            result += remain;
            if (result >= 0) {
                if (result / 100 > 0) {
                    save += 100 * (result / 100);
                    result -= 100 * (result / 100);
                }
            } else {
                System.out.println("-" + (k + 1));
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.print((int)(save * 1.2+result));
        }
    }
}
