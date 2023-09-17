package three;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class P1420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int temp = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> container = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            if (array.get(i) + 1 == array.get(i + 1)) {
                count++;
            } else {
                container.add(count);
                count = 1;
            }
        }
        container.add(count);
        for (int i = 0; i < container.size(); i++) {
            for (int j = 0; j < container.size() - i - 1; j++) {
                if (container.get(j) > container.get(j + 1)) {
                    temp = container.get(j + 1);
                    container.set(j, container.get(j + 1));
                    container.set(j + 1, temp);
                }
            }

        }
        System.out.println(container.get(container.size() - 1));
    }
}
