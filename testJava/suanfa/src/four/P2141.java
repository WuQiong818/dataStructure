package four;

import java.util.Arrays;
import java.util.Scanner;

public class P2141 {
/*    private static Scanner cin;
    public static void main(String[] args) {
                cin = new Scanner(System.in);
                int n = cin.nextInt();
                int ret = 0;
                LinkedList<Integer> list = new LinkedList<Integer>();
                for (int i = 0; i < n; i++) {
                    list.add(cin.nextInt());
                }
                Integer[] array = new Integer[list.size()];
                list.toArray(array);
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (j != i) {
                            for (int k = j + 1; k < array.length; k++) {
                                if (k != i && array[j] + array[k] == array[i]) {
                                    ret++;
                                    k = array.length;
                                    j = k;
                                }
                            }
                        }
                    }
                }
                System.out.println(ret);
            }
        }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (array[i] == array[j] + array[k] && array[j] != array[k]) {
                        count++;
                        j= array.length;;
                        break;
                    }
                }
            }

        }
        System.out.println(count);
    }
}
