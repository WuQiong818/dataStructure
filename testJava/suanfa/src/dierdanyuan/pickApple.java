package dierdanyuan;

import java.util.Scanner;

public class pickApple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] array=new int[10];
        for (int i=0;i<10;i++){
            array[i]=sc.nextInt();
        }
        int hand=sc.nextInt()+30;
        int sum=0;
        for (int j=0;j<10;j++){
            if (hand>=array[j]){
                sum++;
            }
        }
        System.out.print(sum);
    }
}
