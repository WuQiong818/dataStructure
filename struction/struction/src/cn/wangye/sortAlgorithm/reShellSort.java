package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class reShellSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int step = array.length;
        int temp = 0;

     /*   do {
            step /= 2;//小数组的步长，间距为5；同时分为5个数组
            for (int i = 0; i < array.length / step; i++) {
                for (int j = 0; j < array.length - step; j++) {//内层最重要的作用是保证交换的时候，不发生下标的越界，其次才是局部的优化；
                    if (array[j] > array[j + step]) {
                        temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
            System.out.println(step);
            System.out.println(Arrays.toString(array));
        }while (step != 1);*/

        //移位法,最后面的数为有序数组，前面为无序数组
        do {
            step /= 2;//小数组的步长，间距为5；同时分为5个数组
            for (int i = array.length - step - 1; i >= 0; i--) {
                int insertVal = array[i];
                int insertIndex = i + step;
                while (insertIndex < array.length && insertVal > array[insertIndex]) {
                    array[insertIndex-step] = array[insertIndex];
                    insertIndex += step;
                }
                array[insertIndex-step] = insertVal;//从前面for循环出来的数，大概率是下标越界的数，因此这里把加上的步长给减去。
            }
            System.out.println(step);
            System.out.println(Arrays.toString(array));
        } while (step != 1);


/*        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        array[j] = array[j-gap];
                        j-=gap;
                    }
                }
                array[j] = temp;
            }
        }
        System.out.println(Arrays.toString(array));*/







       /* //具体举例
        //第一次:
        step /= 2;//小数组的步长，间距为5；同时分为5个数组
        for (int i = 0; i < array.length / step; i++) {
            for (int j = 0; j < array.length - step; j++) {//内层最重要的作用是保证交换的时候，不发生下标的越界，其次才是局部的优化；
                if (array[j] > array[j + step]) {
                    temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));

        //具体举例
        //第一次:
        step /= 2;//小数组的步长，间距为5；同时分为5个数组
        for (int i = 0; i < array.length / step; i++) {
            for (int j = 0; j < array.length - step; j++) {//内层最重要的作用是保证交换的时候，不发生下标的越界，其次才是局部的优化；
                if (array[j] > array[j + step]) {
                    temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        //具体举例
        //第一次:
        step /= 2;//小数组的步长，间距为5；同时分为5个数组
        for (int i = 0; i < array.length / step; i++) {
            for (int j = 0; j < array.length - step; j++) {//内层最重要的作用是保证交换的时候，不发生下标的越界，其次才是局部的优化；
                if (array[j] > array[j + step]) {
                    temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));*/
    }
}


