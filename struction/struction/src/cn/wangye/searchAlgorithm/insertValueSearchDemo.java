package cn.wangye.searchAlgorithm;

public class insertValueSearchDemo {
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int[] arr = new int[100];
        for (int i = 1; i < 101; i++) {
            arr[i - 1] = i;
        }
        int findValue = 55;
        int left = 0;
        int right = arr.length - 1;
        int index = insertValueSearch(arr, findValue, left, right);
        System.out.println(index);
    }

    private static int insertValueSearch(int[] arr, int findValue, int left, int right) {
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);//注意这一个公式的表达，乘法在前面;
        System.out.println(mid);
        if (left > right) {
            return -1;
        }
        if (arr[mid] > findValue) {//向左递归
            return insertValueSearch(arr, findValue, left, mid - 1);
        } else if (arr[mid] < findValue) {//向右递归
            return insertValueSearch(arr, findValue, mid + 1, right);
        } else {
            return mid;
        }
    }
}
