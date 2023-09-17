package three;

import java.math.BigDecimal;
import java.util.Scanner;

public class test05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        BigDecimal result=new BigDecimal("0");
        BigDecimal collection=new BigDecimal("1");
        for (int i=0;i<num;i++){
            for (int j=1;j<=num-i;j++){
                collection=collection.multiply(new BigDecimal(j+""));
            }
            result=result.add(collection);
            collection=new BigDecimal("1");
        }
        System.out.print(result);
    }
}
