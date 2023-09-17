package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class mergeSortDemo {
    public static void main(String[] args) {
        int[] array = {8, 4, 10, 5, 7, 9, 1, 3, 6, 2};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length-1,temp);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }


    /**
     * 分治算法中的治，用来对分后的算法进行排序
     *
     * @param array 待排序数组
     * @param left  最左边数组的坐标起始值
     * @param mid   中间的左边
     * @param right 数组的终点,最右边的下标数，length-1
     * @param temp  临时存储变量的数据
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        //1.左右两个数组进行比较，向临时数组中填充数据,当前i,j数组的下标进行数的比大小;
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            }

            if (array[j] <= array[i]) {
                temp[k] = array[j];
                j++;
                k++;
            }
        }
        //2.将左边，或者右边剩余下来的数据，直接填充到右边;
        //算法能够执行到这里，一个默认的条件就是i>mid或者j>right,看之前的while循环的条件
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        //3.将临时数组中的数据复制到原数组array中;
        k = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[k];
            tempLeft++;
            k++;
        }
    }

}
