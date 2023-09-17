package dierdanyuan;

import java.util.Scanner;

public class advancedISBN {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String first=str.substring(0,str.length()-1);
        int j=1;
        int sum=0;
        for(int i=0;i<first.length()-1;i++){
            if (first.charAt(i)!='-'){
                sum+=j*Integer.parseInt(String.valueOf(first.charAt(i)));
                j++;
            }
        }
        if (str.charAt(str.length()-1)=='X'){
            if (sum%11==10){
                System.out.print("Right");
            }else{
                System.out.print(first+sum%11);
            }
        }else{
            if (sum%11==Integer.parseInt(String.valueOf(str.charAt(str.length()-1)))){
                System.out.print("Right");
            }else{
                System.out.print(sum%11==10?first+'X':first+sum%11);
            }
        }
    }
}
