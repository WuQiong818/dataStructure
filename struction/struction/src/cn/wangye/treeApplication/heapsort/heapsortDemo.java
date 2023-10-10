/*
package cn.wangye.treeApplication.heapsort;

import java.util.Arrays;

public class heapsortDemo {

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 5, 9};
        int temp = 0;
   */
/*
   思路：
   1.将无序数组构建成大顶堆,此时，堆顶元素为数组中的最大值
        1.1从最后一个非叶子节点，一直遍历到第一个非叶子节点，即根节点，array[array.length]/2-1=>0 这是一个for循环
        1.2在进行非叶子节点比较、交换的过程中会涉及到一个对交换后节点的影响问题，【没有解决】（死于这一步）
   2.将堆顶元素与末尾元素进行交换
   3.重新构建大顶堆，不断重复这一个过程.
   伪代码：
   *//*


        */
/*
         * 这里我们使用j,来控制数据交换的范围
         *
         * *//*

        for (int j = 0; j < array.length - 2; j++) {
            for (int i = (array.length - j) / 2 - 1; i >= 0; i--) {
                */
/*
                 * 没有考虑到交换过后所引起的后续问题,我们需要对交换后元素和其左右子节点再次进行对比，如果不符合，则在次进行交换。
                 * 如果不使用递归，这里while循环就是最好的方法了
                 * *//*

                while (array[i] < array[2 * i + 1] || (array[i] < array[2 * i + 2])) {


                }


//                if (array[i] < array[2 * i + 1]) {
//                    temp = array[2 * i + 1];
//                    array[2 * i + 1] = array[i];
//                    array[i] = temp;
//                    while(){}
//
//
//                }
//                if ((array.length - j) % 2 != 0) {
//                    if (array[i] < array[2 * i + 2]) {
//                        temp = array[2 * i + 2];
//                        array[2 * i + 2] = array[i];
//                        array[i] = temp;
//                    }


            }
        }
        System.out.print("未交换");
        System.out.println(Arrays.toString(array));


        //大顶堆已经构建完成，接下来进行进行顶堆元素和末尾元素的交换
        temp = array[0];
        array[0] = array[array.length - 1 - j];
        array[array.length - 1 - j] = temp;
        System.out.print("已交换");
        System.out.println(Arrays.toString(array));
    }
}
}
*/
