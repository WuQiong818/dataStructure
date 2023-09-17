package cn.wangye.sortAlgorithm;

public class selectedSort {
    public static void main(String[] args) {
//        int[] array = {101, 34, 119, 1,-1,90,123};
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        int min = array[0];
        int index = -1;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            //这里可以优化一下,如果自己是min,就跳过交换
            if (index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                min = 100000;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
