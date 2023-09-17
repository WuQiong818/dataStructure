package diyidanyuan;

/*
* 1.通过输入的数字计算桶的体积
* 2.使用double类型的20除以桶体积
* 3.将桶数进行化整；
* */

import java.util.Scanner;

public class elephantDrink {
    public static void main(String[] args) {
        double PI=3.14;
        double need=20;
        Scanner sc=new Scanner(System.in);
        Double high=sc.nextDouble();
        Double radius=sc.nextDouble();
        //对volume体积从ml转化为L
        double volume=(high*radius*radius*PI)/1000;
        int count=(int)Math.ceil(need/volume);
        System.out.println(count);
    }
}
