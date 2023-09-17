package four;

import java.util.Scanner;

public class P1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Long min = 100000000L;
        Long sum = 0L;
        int [] array = new int[n];
        for (int i= 0;i<n;i++){
            array[i]=sc.nextInt();
        }
        for(int j = 0;j<array.length-m+1;j++){
            for (int k = 0; k<m ;k++){
                sum += array[j+k];
            }
            if (sum<min){
                min=sum;
            }
            sum=0L;
        }
        System.out.println(min);
    }

}
