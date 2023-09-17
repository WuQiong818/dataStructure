package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class shellDemo {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        changeShell(array);
    }

    private static void changeShell(int[] array) {
        int temp = 0;
        int count = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            ++count;
            System.out.println("这是第" + count + "个" + Arrays.toString(array));


        }
    }
}

