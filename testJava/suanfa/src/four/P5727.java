package four;

import java.util.Scanner;

public class P5727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int count =0;
        int [] array = new int[200];
        array[count]=n;
        while(n!=1){
            count++;
            if(n%2==0){
                n=n/2;
                array[count]= n;
            }else{
                n=n*3+1;
                array[count]= n;
            }
        }
        for (int i =count;i>=0;i--){
            System.out.print(array[i]+" ");
        }
    }
}
