package five;

import java.util.Scanner;

public class P3741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String str = sc.next();
        int count = 0;
        char[] array = new char[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = str.charAt(i);
        }
        //直接进行两次搜索即可
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == 'V' && array[i + 1] == 'K') {
                count++;
                array[i] = 0;
                array[i + 1] = 0;
            }
        }
        for(int i =0;i<array.length-1;i++){
            if (array[i] == 'V' && array[i + 1] == 'V' ){
                count++;
                break;
            } else if (array[i] == 'K' && array[i + 1] == 'K' && i + 1 <= array.length - 1) {
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}


/*
*     public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int length = sc.nextInt();
        String str = sc.next();

        String[] strArray = str.split("VK");
        int count = 0;
        boolean flag = false;
        for (String array : strArray) {
            count++;
            for (int i = 0; i < array.length(); i++) {
                if (array.charAt(i) == 'V') {
                    if (array.charAt(i+1)=='V'){
                        flag = true;
                        break;
                    }
                } else if (array.charAt(i) == 'K') {
                    if (array.charAt(i+1)=='K'){
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (flag){
            count++;
        }
        System.out.print(count);
    }
* */
