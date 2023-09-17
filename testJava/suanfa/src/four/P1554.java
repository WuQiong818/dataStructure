package four;

import java.util.Scanner;

public class P1554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int num7 = 0;
        int num8 = 0;
        int num9 = 0;
        String str="";
        int min = sc.nextInt();
        int max = sc.nextInt();
        for (int i = min;i<=max;i++){
            str=String.valueOf(i);
            for (int j =0;j<str.length();j++){
                if (str.charAt(j)=='0'){
                    num0++;
                }else if (str.charAt(j)=='1'){
                    num1++;
                }else if (str.charAt(j)=='2'){
                    num2++;
                }else if (str.charAt(j)=='3'){
                    num3++;
                }else if (str.charAt(j)=='4'){
                    num4++;
                }else if (str.charAt(j)=='5'){
                    num5++;
                }else if (str.charAt(j)=='6'){
                    num6++;
                }else if (str.charAt(j)=='7'){
                    num7++;
                }else if (str.charAt(j)=='8'){
                    num8++;
                }else if (str.charAt(j)=='9'){
                    num9++;
                }
            }
        }
        System.out.print(num0+" "+num1+" "+num2+" "+num3+" "+num4+" "+num5+" "+num6+" "+num7+" "+num8+" "+num9);


    }
}
