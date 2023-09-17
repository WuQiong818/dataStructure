package four;

import java.util.Scanner;

public class P2911 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[] summarizing = new int[x + y + z + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                for (int k = 1; k <= z; k++) {
                    summarizing[i+j+k]++;
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < summarizing.length; i++) {
            if (max < summarizing[i]) {
                max = summarizing[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);

/*        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int [] allArray = new int [x*y*z];
        int index=0;
        int [] summarizing = new int[x+y+z+1];

        for (int i =1;i<=x;i++){
            for (int j =1;j<=y;j++) {
                for (int k =1;k<=z;k++){
                    allArray[index]=i+j+k;
                    index++;
                }
            }
        }
        for (int i=0;i<x*y*z;i++){
            summarizing[allArray[i]]++;
        }
        int max =0;
        int sumIndex=0;
        for (int i=1;i<summarizing.length;i++){
            if (max<summarizing[i]){
                max = summarizing[i];
                sumIndex =i;
            }
        }
        System.out.println(sumIndex);*/
    }
}
