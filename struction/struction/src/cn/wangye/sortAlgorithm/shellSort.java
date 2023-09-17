package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class shellSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        changeShell(array);
    }

    private static void changeShell(int[] array) {
        int gap = array.length;
        int temp = 0;
        int count = 0;
        /*while (gap != 1) {
            gap /= 2;
            //gap = 2 ,分成2组，每组五个，一个数和后面的所有数进行比较，小的在前，大的在后;
            //这里其实就相当于是对间距为2的数组分别进行排序，和正常的排序差不多，不同的是下标，冒泡玩一下
            for (int k = 0; k < gap; k++) {//数组的个数由间距决定，间距为4，分为4个数组
                for (int i = 0; i < array.length / gap - 1; i++) {//每一个数组一共有多少数，length/gap;
                    for (int j = k; j < array.length - gap; j += gap) {//这个数根据间距，进行数的排序；
                        if (array[j] > array[j + gap]) {
                            temp = array[j];
                            array[j] = array[j + gap];
                            array[j + gap] = temp;
                        }
                    }
                }
            }
            count++;
            System.out.println("第"+count+"次gap" + Arrays.toString(array));
        }
*/

        gap /= 2;
        //直接写写不出来，使用举例的方法写
        for (int i = 0; i < 5; i++) {//gap = 5 ,分成5组,每组2个，两个数相互比较即可
            if (array[i] > array[i + gap]) {
                temp = array[i];
                array[i] = array[i + gap];
                array[i + gap] = temp;
            }
        }
        System.out.println("第一次gap" + Arrays.toString(array));

        gap /= 2;
        //gap = 2 ,分成2组，每组五个，一个数和后面的所有数进行比较，小的在前，大的在后;
        //这里其实就相当于是对间距为2的数组分别进行排序，和正常的排序差不多，不同的是下标，冒泡玩一下
//        for (int k = 0; k < 2; k++) {//循环两次，一共两个数组//这里是想复杂了,其实不需要这样整,直接进行排序即可
        for (int i = 0; i < 5 - 1; i++) {//一共5个数，走四趟即可,一共是两组,走四趟即可,不管他分成数组,这一个没关系
            for (int j = 0; j < array.length - gap - i * gap; j++) {
                if (array[j] > array[j + gap]) {
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
            }
        }
//        }
        System.out.println("第二次gap" + Arrays.toString(array));


        gap /= 2;
        //gap = 1 ,分成1组，每组10个，一个数和后面的所有数进行比较，小的在前，大的在后;
        //这里其实就相当于是对间距为1的数组分别进行排序，和正常的排序差不多，不同的是下标，冒泡玩一下
        for (int k = 0; k < 1; k++) {//循环一次，一共一个数组
            for (int i = 0; i < 10 - 1; i++) {//一共10个数，走九趟即可
                for (int j = k; j < array.length - gap; j += gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println("111" + Arrays.toString(array));

    }
}
