package dierdanyuan;
import java.util.Scanner;
public class lestCost {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        float need=sc.nextFloat();
        float choice1=sc.nextFloat();
        float price1=sc.nextFloat();
        float choice2=sc.nextFloat();
        float price2=sc.nextFloat();
        float choice3=sc.nextFloat();
        float price3=sc.nextFloat();

        int cost1=(int) (Math.ceil(need/choice1)*price1);
        int cost2=(int) (Math.ceil(need/choice2)*price2);
        int cost3=(int) (Math.ceil(need/choice3)*price3);

        if (cost1<cost2&&cost1<cost3){
            System.out.print(cost1);
        }else if (cost2<cost1&&cost2<cost3){
            System.out.print(cost2);
        }else{
            System.out.print(cost3);
        }
    }
}
