package cn.wangye.sortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/*
* 对应到javaWeb项目中实际上就是对orderId进行去重操作，
*
* */
public class test1 {
    public static void main(String[] args) {
        int [] array = {1,1,2,2,2,3,4};
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i< array.length;i++){
            int value = array[i];
            for (int j = i+1;j< array.length;j++){
                int nextValue = array[j];
                if (value==nextValue){
                    /*这个还可以有其他操作;*/
                    i++;
                }
            }
            list.add(value);
        }
        System.out.println(Arrays.toString(new List[]{list}));
    }
}
