package cn.wangye.searchAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binarySearchDemo {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000,1000, 1000, 1234};
        int fondValue = 0;
        int left = 0;
        int right = arr.length - 1;
//        int index = binarySearch(left, right, arr, fondValue);
//        if (index == -1) {
//            System.out.println("没有查找到该值");
//        } else {
//            System.out.println("改值的下标是" + index);
//        }
        List<Integer> list = binarySameSearch(left, right, arr, fondValue);
        System.out.println(Arrays.toString(new List[]{list}));
    }

    private static int binarySearch(int left, int right, int[] arr, int fondValue) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        System.out.println(mid);

        //获取中间值，根据中间值确定向左，还是向右查找
        if (arr[mid] > fondValue) {
            return binarySearch(left, mid - 1, arr, fondValue);
        } else if (arr[mid] < fondValue) {
            return binarySearch(mid + 1, right, arr, fondValue);
        } else {
            return mid;
        }
    }

    private static List<Integer> binarySameSearch(int left, int right, int[] arr, int fondValue) {
        List<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }
        int mid = (left + right) / 2;
        System.out.println(mid);

        //获取中间值，根据中间值确定向左，还是向右查找
        if (arr[mid] > fondValue) {
            return binarySameSearch(left, mid - 1, arr, fondValue);
        } else if (arr[mid] < fondValue) {
            return binarySameSearch(mid + 1, right, arr, fondValue);
        } else {
            list.add(mid);
            for (int i = mid-1;i>0;i--){//向左
                if (arr[i]==fondValue){
                    list.add(i);
                }else{
                    break;
                }
            }
            for (int i = mid+1;i<arr.length;i++){//向右
                if (arr[i]==fondValue){
                    list.add(i);
                }else{
                    break;
                }
            }
            return list;
        }
    }
}
