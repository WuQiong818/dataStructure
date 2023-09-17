package diyidanyuan;
import java.text.DecimalFormat;
import java.util.Scanner;
public class feizhashui {
        public static void main(String[]args){
            Scanner sc=new Scanner(System.in);
            double ml=sc.nextDouble();
            int population=sc.nextInt();
//            DecimalFormat df=new DecimalFormat("#.###");
//            System.out.println(df.format(ml/population));
            System.out.print(String.format("%.1f",ml/population));
            System.out.println(population*2);

    }
}
