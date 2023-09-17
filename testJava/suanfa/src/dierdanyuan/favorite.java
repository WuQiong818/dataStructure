package dierdanyuan;

import java.util.Scanner;

public class favorite {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int number=sc.nextInt();
//        //都符合
//        if (number%2==0&&number>4&&number<=12){
//            System.out.print(1+"\u0020");
//        }else{
//            System.out.print(0+"\u0020");
//        }
//        //至少符合一个 注意与和短路与
//        if (number%2==0|number>4&&number<=12){
//            System.out.print(1+"\u0020");
//        }else{
//            System.out.print(0+"\u0020");
//        }
////        只符合一个
//        if (number%2==0){
//            if (number<=4||number>12){
//                System.out.print(1+"\u0020");
//            }else{
//                System.out.print(0+"\u0020");
//            }
//        }else if(number>4&&number<=12){
//            if (number%2!=0){
//                System.out.print(1+"\u0020");
//            }else{
//                System.out.print(0+"\u0020");
//            }
//        }else{
//            System.out.print(0+"\u0020");
//        }
////        一个都不符合
//        if (number%2!=0&&number<4|number>12){
//            System.out.print(1+"\u0020");
//        }else{
//            System.out.print(0+"\u0020");
//        }
//    }

    //    改进后
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0;
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if (count % 2 == 0 && count > 4 && count <= 12) {
            a = 1;
        }
        if (count % 2 == 0 || count > 4 && count <= 12) {
            b = 1;
        }
        if (count%2==0&&count<=4||count>12||count%2!=0&&count>4&&count<=12){
            c=1;
        }
        if (count%2!=0&&count<=4||count>12){
            d=1;
        }
        System.out.print(a+" "+b+" "+c+" "+d);
    }

}
