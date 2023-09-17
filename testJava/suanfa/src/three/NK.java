package three;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class NK {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        double sum1=0;
        double sum2=0;
        for (int i=1;i<=n;i++){
            if(i%k==0){
                array1.add(i);
            }else{
                array2.add(i);
            }
        }
        for (int element:array1
             ) {
            sum1+=element;
        }
        for (int i=0;i<array2.size();i++){
            sum2+=array2.get(i);
        }
        double ave1=sum1/array1.size();
        double ave2=sum2/array2.size();
        DecimalFormat df=new DecimalFormat("#.0");
        System.out.print(df.format(ave1)+" "+df.format(ave2));
    }
}
