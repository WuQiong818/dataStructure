package cn.wangye.searchAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class feiBoSearchDemo {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1,1234,1000,100,5,55,88,99999};
        int key = 1234;
        int left = 0;
        int high = arr.length-1;
        int k = 0;
        int[] fib = fib();
        while (high > fib[k] - 1) {
            k++;
        }
        System.out.println("k="+k);
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp));
            System.out.println(high);
            temp[i] = arr[high];
        }


        System.out.println("index1=" + fibSearch(arr, key));
        System.out.println("index2=" + fibSearch1(temp, key, left, high, k));

    }


    public static int fibSearch1(int[] temp, int key, int low, int high, int k) {
        if (k < 0 || low > high) {
            return -1;
        }
        int[] fib = fib();
        int mid = low + fib[k - 1] - 1;
        if (temp[mid] > key) {//向左
            k--;
            return fibSearch1(temp, key, low, mid - 1, k);
        } else if (temp[mid] < key) {//向右
            k -= 2;
            return fibSearch1(temp, key, mid + 1, high, k);
        } else {
            if (mid <= high) {
                return mid;
            } else {
                return high;
            }
        }
    }

    /**
     * 非递归,普通的斐波那契查找
     *
     * @param arr 查找数组
     * @param key 查找值
     * @return
     */
    public static int fibSearch(int[] arr, int key) {
        //先把数组给补充了，让其长度等于f(k)-1.
        int k = 0;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int[] fib = fib();
        while (high > fib[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {//向左
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {//向右
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }


    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}

