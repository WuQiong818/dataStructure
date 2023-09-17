package dierdanyuan;

import java.util.Arrays;
import java.util.Scanner;

public class sinTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        for (int i=0;i<3;i++){
        array[i] = sc.nextInt();
        }
        //冒泡 从小到大排序；
        int max = 0;
        for (int i = 0; i < array.length-1 ; i++) {
            for (int j = 0; j < array.length-1-i ; j++) {
                if (array[j] > array[j+1]) {
                    max=array[j];
                    array[j]=array[j+1];
                    array[j+1]=max;
                }
            }
        }
        int a=array[0];
        int b=array[array.length-1];
        for(int k=2;k<=a;k++){
            if (a%2==0&&b%2==0){
                a=a/2;
                b=b/2;
            }
        }
        System.out.print(a+"/"+b);
    }
}

