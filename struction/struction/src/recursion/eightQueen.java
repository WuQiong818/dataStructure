package recursion;

/*思路分析：
 * 回溯算法递归
 * 为什么使用回溯算法:
 * 寻找所有的可能性，将一个大的事件进行拆分,如果不符合，就跳回上一级，继续去寻找另一种可能，返回的过程叫做算法的回溯
 *使用一个一维数组去代替二维数组，更加简便一些：
 * 条件判断：
 * 1.横向：一行只能有一个皇后：直接符合
 * 2.纵向：一列只能有一个皇后，数字不能相同
 * 3.斜向：数字不能连续 不能出现123之类的连续数字
 *
 * 核心算法：皇后放置问题：
 * 需要将数组作为参数，每一次都是在同一个数组上进行修改
 * place(int [] array){
 * int i =0;
 * }
 *
 * */
public class eightQueen {
    public static int[] array = new int[8];//直接将数组声明为成员变量,就不需要将数组作为参数来回传了

    public static void main(String[] args) {
        place(0);
    }

    //书写皇后的放置方法：
    public static void place(int n) {
        if (n == array.length) {
            print();
            return;
        }
        //在这里进行皇后的放置
        //i的条件判断，但i<array.length,不管怎么地都会进入循环之后，最后得到的一定是false
        for (int i = 0; i < array.length; i++) {
            array[n] = i;
            if (judge(n)) {//判断第n个皇后在i的位置上合适不合适，如果一轮循环坚持下来了，就是合适的
                place(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;//只要满足一次，就赋值为false,跳出条件的判断，为第n个皇后寻找合适的位置。
            }
        }
        return true;
    }

    public static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(12);
    }
}
