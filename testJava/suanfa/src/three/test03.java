package three;


import java.util.Scanner;

public class test03 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        for (int i=0;i<num;i++){
            for (int j=0;j<num-i;j++){
                count++;
                if (count<10){
                System.out.print("0"+count);
                }else{
                    System.out.print(count);
                }
            }
            System.out.println();
        }
    }
}
