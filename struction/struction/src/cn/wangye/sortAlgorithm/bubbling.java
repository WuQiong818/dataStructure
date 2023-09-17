package cn.wangye.sortAlgorithm;
/*
 * 目前自己能写出来的冒泡，执行次数为10
 * 时间复杂度还是n*n
 * */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class bubbling {
    static double count = 0;
    static boolean flag = false;

    public static void main(String[] args) {
//        int[] array = {3, 9, -1, 10, -2};

        int [] array = new int[80000];
        for(int i = 0;i<array.length;i++){
            array[i] = (int) (Math.random()*8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str =  simpleDateFormat.format(date1);
        System.out.println("排序前的时间为"+data1Str);
        sort(array);
        Date date2 = new Date();
        String data2Str =  simpleDateFormat.format(date2);
        System.out.println("排序前的时间为"+data2Str);
    }

    public static void sort(int[] array) {
        //使用冒泡法，将array数组中的数从小到大进行排列
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
//            System.out.println("这是第" + i + "趟");

//            System.out.println();
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println(count);
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

}