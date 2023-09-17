package dierdanyuan;
/*
 * 1.接收，键盘录入，使用数组进行接受
 * 2.计算0,1和2,3；计算每天津津的总学习时间
 * 3.总学习时间进行判断，输出对应的结果；
 * 星期
 * 最不高兴的是周几 需要又比较的过程 声明临时变量
 *
 * */


import java.util.Scanner;

public class goLesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[14];
        int date=0;
        int temp = 0;
        for (int i = 0; i < 14; i++) {
            array[i] = sc.nextInt();
        }
        for (int j = 0; j < 14; j += 2) {
            int count = array[j] + array[j + 1];
            if (count > 8) {
                if (temp < count) {
                    temp = count;
                    date = (j + 2) / 2;
                }
            }
        }
        if (temp==0){
            System.out.print(0);
        }else{
            System.out.println(date);
        }

    }

}

