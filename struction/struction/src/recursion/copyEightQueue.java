package recursion;


public class copyEightQueue {
    static int max = 8;
    static int[] array = new int[max];
    static int count;
    static int judgeCount;

    public static void main(String[] args) {
        check(0);
        System.out.println("count=" + count);
        System.out.println("judgeCount=" + judgeCount);
    }

    private static void check(int n) {
        if (n == max) {//当用户放置的皇后数等于数组的长度时，递归停止。
            print();
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[n] = i;//先降第n个皇后放置到i的位置上,进行条件的判断，皇后放到这里合适吗？
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        judgeCount++;
        /*如何判断:
         * 判断与之前放置的皇后是否冲突，一定是for循环，终止条件，第n个皇后之前的所有皇后,所有需要传入n
         * 什么时候判断为冲突？
         * 同行:一维数组，直接满足。因为下标唯一
         * 同列:一维数组中的数都不相同 array[i] == array[n]
         * 斜对眼:这个奥义就比较深了math.abs(array[n]-array[i]) == math.abs(n-i)
         * */
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        count++;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
