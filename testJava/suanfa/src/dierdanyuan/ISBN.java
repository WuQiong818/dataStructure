package dierdanyuan;

import java.util.Scanner;
        public class ISBN {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                String after=str.substring(0,str.length()-1);
                int [] array =new int[10];
                int k=0;
                int sum=0;

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i)!='-'){
                array[k]= Integer.parseInt(String.valueOf(str.charAt(i)));
                k++;
            }
        }
        for (int j=1;j<=array.length-1;j++){
            sum=sum+array[j-1]*j;
        }


        if (sum%11==array[array.length-1]){
            System.out.print("Right");
        }else{
            System.out.print(sum%11==10?after+'X':after+sum%11);
        }
    }
}
