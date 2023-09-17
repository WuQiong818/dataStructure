package diyidanyuan;


/*
* 1.计算路程上面所花费的时间 t=Math.ceil(s/v)+10;
* 8:00减去路程上所花费的时间
* 先减分位，再减时位；
* */
import java.util.Scanner;
public class school {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        double s=sc.nextDouble();
        double v=sc.nextDouble();
        int spend= (int) Math.ceil(s/v)+10;
        int start=24*60-spend;
        int hour=start/60;
        int minute=start%60;
        if (hour>16){
            hour-=16;
        }else{
            hour+=8;
        }
        String shifthour=(hour<10)? "0"+Integer.toString(hour) :Integer.toString(hour);
        String shifttimer= (minute<10)? "0"+Integer.toString(minute) :Integer.toString(minute);
        System.out.print(shifthour+":"+shifttimer);
    }
}





















