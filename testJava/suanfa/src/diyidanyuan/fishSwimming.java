package diyidanyuan;
/*
* 1.获取abcd四个数字
* 2.进行判断 开始时间不能晚于结束时间
* 2.在if中进行运算
* 3.先计算b-d,不够减，用时位退一
* */
import java.util.Scanner;
public class fishSwimming {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int e;
        int f;
        if (a*60+b<c*60+d){
            if(d-b<0){
               e=c-1-a;
               f=d+60-b;
            }else{
                e=c-a;
                f=d-b;
            }
            System.out.print(e+" "+f);
        }
    }
}
