package cn.wangye.sortAlgorithm;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static Random random = new Random();

    public static void main(String[] args) {

        int[] array = {21, 567, 20, -5, -3};
//        int[] array = {21, 567};

        quickSort3(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

/*    private static void quickSort2(int[] array, int left, int right) {
        if (left >= right) return;//递归的终止条件
        int randomIndex = random.nextInt(right - left) + left;
        int num = array[randomIndex];
        swap(array, randomIndex, right);
        *//*
     * 这里是用j来遍历整个数组，用i来控制大于随机数的数，一旦j遍历到小于随机数的值，就必然发生交换。
     * *//*
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= num) {
                swap(array, i++, j);
            }
        }
        swap(array, i, right);  //为什么和i惊醒交换，因为i永远都是第一个大于随机数的数。和i进行交换可以保证左边的数都小于这一个随机数
        quickSort2(array, left, i - 1);
        quickSort2(array, i + 1, right);
    }*/


    private static void quickSort3(int[] array, int left, int right) {
        if (left >= right) return;
        Random random = new Random();
        int randomIndex = random.nextInt(right - left) + left;
        System.out.println(randomIndex);//1时下标会越界
        int num = array[randomIndex];
        swap(array, randomIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= num) {
                swap(array, i++, j);
            }
        }
        swap(array, i, right);
        System.out.println(Arrays.toString(array));
        quickSort3(array, left, i - 1);
        quickSort3(array, i + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


  /*  private static void quickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        int temp = 0;
        //之后进行排序就可以了，让左边的值都小于pivot;让右边的值都大于pivot;
        while (left < right) {
            while (array[left] < pivot) {//这里要使用while,让其一直循环，直到找到了一个大于中间值的数，才停止;有可能出现=pivot的情况，这时候while循环也会停止;
                left += 1;
            }
            while (array[right] > pivot) {//只有在右边找到小于pivot的数，才会停止；
                right -= 1;
            }
            if (left >= right) {
                break;//while循环的终止条件一定是左右两边的数汇合了
            }

            temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            System.out.println(12);

            if (array[left] == pivot) {
                right -= 1;
            }
            if (array[right] == pivot) {
                left += 1;
            }
        }
    }*/
}
