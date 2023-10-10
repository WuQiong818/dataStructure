package cn.wangye.treeApplication.heapsort;

import java.util.Arrays;

public class heapsort1 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 2, 1};
//        int[] arr = {4, 6, 8, 5, 9};
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("第一次构建堆");
        System.out.println(Arrays.toString(arr));

        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            System.out.print("交换后");
            System.out.println(Arrays.toString(arr));//将堆顶元素与末尾元素进行交换后，我们需要调整堆的顺序。
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }


    //书写一个方法，用于帮助我们进行非叶子节点的交换
    //adjustHeap方法是用于对非叶子节点元素的调整，第一次是从最后一个非叶子节点到根节点进行全部调整，以后就是仅仅对根节点进行调整即可
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//先进性判断子树的，左叶子节点和右叶子节点值的大小
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//让temp回到i的位置上
    }
}
