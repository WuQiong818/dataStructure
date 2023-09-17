package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 1, 33, 34, 100};
//        int[] array = {101,100};
        /*int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000);
        }*/
        stepShell(array);
    }

    private static void stepShell(int[] array) {//步长为2 step = 2
        int step = 2;
        for (int i = array.length - step - 1; i >= 0; i--) {
            int insertVal = array[i];
            int insertIndex = i + step;
            while (insertIndex < array.length && insertVal > array[insertIndex]) {//不越界和平移判断
                array[insertIndex-step] = array[insertIndex];
                insertIndex += 2;
            }
            array[insertIndex-step] = insertVal;
            System.out.println(Arrays.toString(array));
        }
    }




 /*   private static void userDefined(int[] array) {//向前排序和向后排序是一样的，本质上相同，就是进行排列的坐标不同罢了
        for (int i = array.length - 2; i >= 0; i--) {
            int insertVal = array[i];
            int insertIndex = i + 1;
            while (insertIndex < array.length && insertVal > array[insertIndex]) {
                array[insertIndex-1]=array[insertIndex];
                insertIndex++;//这里的位置写反了，先换值，在进行++;
            }
            array[insertIndex-1] = insertVal;
            System.out.println(Arrays.toString(array));
        }
    }*/

    private static void insertFromMaxToMinSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal > array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertVal;
            System.out.println(Arrays.toString(array));
        }
    }

    private static void insertFromMinToMaxSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(array));

        /*int insertVal = array[1];
        int insertIndex = 1 - 1;//和这一个数前面的数字相比较，如果比其大，在其后插入，这个下标应该是动态的
//insertVal < array[insertIndex]insertVal和有序列表中的数进行比较，从大到小一个一个进行比较，如果结果是小于就说明还需要继续向前去比较
        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        //这里下标就是正确的了，insertVal正好大于前一个数字，条件符合进行插入
        array[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(array));

        insertVal = array [2];
        insertIndex = 2-1;
        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        //这里下标就是正确的了，insertVal正好大于前一个数字，条件符合进行插入
        array[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(array));

        insertVal = array [3];
        insertIndex = 3-1;
        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        //这里下标就是正确的了，insertVal正好大于前一个数字，条件符合进行插入
        array[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(array));*/
    }
}
