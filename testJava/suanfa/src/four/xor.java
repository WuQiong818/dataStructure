package four;

public class xor {
    public static void main(String[] args) {
    /*    int [] array = {1,2,3,5,1,2,3};
        //由于为运算符满足结合律和交换律，所以无论中间的sum怎么变，最终的结果一定是那一个不同的数；
        int sum = 0 ;//之所以初始化为0,是因为0不影响后续的运算，进行加法求和的初始值为0一样
        for (int i= 0;i<array.length;i++){
            sum ^= array[i];
            System.out.println(sum);
        }
    }*/
        char ch = '/';
        int[] array = new int[4];
        array[0] = '/';
        array[1] = '*';
        System.out.println(array[0]);
        System.out.println(array[1]);
        if(array[0]=='/'){
            System.out.println(12+ array[0]+ 4);
        }
    }
}
