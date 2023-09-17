package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class test {
    //实现一个效果，每二个为一组进行排序
    public static void main(String[] args) {
        int[] array = {9, 5, 8, 4, 7, 3, 6, 2};
        int temp = 0;
        for (int i = 0; i < 4-1; i++) {//这个是数组的长度-1，小数组长度，即你将一个数组划分的长度。
            for (int j = 0; j < array.length-2-(i*2); j++) {
                if (array[j] > array[j + 2]) {
                    temp = array[j + 2];
                    array[j + 2] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
