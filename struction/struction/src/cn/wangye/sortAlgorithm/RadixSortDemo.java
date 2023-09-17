package cn.wangye.sortAlgorithm;

import java.util.Arrays;

public class RadixSortDemo {
    public static void main(String[] args) {
//        int[] array = {53, 3, 542, 1111, 748, 14, 502, 214};
        int [] array = new int[8000000];
        for (int i = 0 ;i< array.length;i++){
            array[i]= (int) (Math.random()*80000000);
        }
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        //自己书写基数排序
        //*第一步:先得到最大的数，获取最大数的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();

        //*第二步：做好准备工作，创建好存放数的桶和记录每一个桶中元素个数的数组
        int[][] bucket = new int[10][array.length];
        int[] bucketElementCount = new int[10];
        int division = 1;

        //*第三步:构建主体算法:放入桶中，从桶中取数据;
        for (int i = 0; i < maxLength; i++) {
            if (i != 0) {
                division *= 10;
            }
            //(3.1)从数组中取数据，向桶中放数据;
            for (int j = 0; j < array.length; j++) {
                int element = array[j] / division % 10;
                bucket[element][bucketElementCount[element]] = array[j];
                bucketElementCount[element]++;
            }
            int index = 0;
            //(3.2)从桶中取数据，向桶中放数据,顺带对桶数组和桶计数数组进行重置
            for (int x = 0; x < bucket.length; x++) {
                for (int y = 0; y < bucketElementCount[x]; y++) {
                    array[index] = bucket[x][y];
//                    bucket[x][y] = 0;//这一个桶重置重置都可以,因为循环条件限制着的，所以并不影响之后的赋值和取值
                    index++;
                }
                bucketElementCount[x]=0;//这个记录各个桶中数据的个数的数组，一定要重置。
            }
        }












/*        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();//在这里得到所有数组中最大的位数;
        int[][] bucket = new int[10][array.length];//定义一个二维数组，行的长度为10，用来表示十个桶，从0到9,列的长度为数组的长度，确保任何数据下标都不越界.
        int[] bucketElementCounts = new int[10];//定义一个数组，用来表示各个桶中已经装填数据的个数，方便数据的存取;

        //采用列举的方法,从个位，十位，百位，一位一位进行排序;
        //第一轮: 从个位开启:
        //向桶中存数据，从数组向桶中存数据
        for (int i = 0; i < array.length; i++) {
            int mod = 1 * 10;
            int division = 1;
            int element = array[i] / division % mod;
//            int ElementCounts = bucketElementCounts[];
            bucket[element][bucketElementCounts[element]] = array[i];
            bucketElementCounts[array[i] % 10]++;
        }
        System.out.println("11111");
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].length; j++) {
                System.out.print(bucket[i][j] + " ");
            }
            System.out.println();
        }
        //从桶中取数据，将数据放置到数组中
        int x = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[x] = bucket[j][k];
                x++;
            }
        }
        System.out.println("第一轮处理后的数据" + Arrays.toString(array));
        //本轮数据重置，方便下一轮数据的使用
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }
        //第二轮: 从十位开始:
        //向桶中存数据，从数组向桶中存数据
        for (int i = 0; i < array.length; i++) {
            int mod = 1 * 10;
            int division = 1 * 10;
            int element = array[i] / division % mod;
            bucket[element][bucketElementCounts[element]] = array[i];
            bucketElementCounts[element]++;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].length; j++) {
                System.out.print(bucket[i][j] + " ");
            }
            System.out.println();
        }
        //从桶中取数据，将数据放置到数组中
        int y = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[y] = bucket[j][k];
                y++;
            }
        }
        System.out.println("第二轮处理后的数据" + Arrays.toString(array));
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }

        //采用列举的方法,从个位，十位，百位，一位一位进行排序;
        //第三轮: 从百位开启:
        //向桶中存数据，从数组向桶中存数据
        for (int i = 0; i < array.length; i++) {
            int mod = 1 * 10;
            int division = 1 * 10 * 10;
            int element = array[i] / division % mod;
            bucket[element][bucketElementCounts[element]] = array[i];
            bucketElementCounts[element]++;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].length; j++) {
                System.out.print(bucket[i][j] + " ");
            }
            System.out.println();
        }
        //从桶中取数据，将数据放置到数组中
        int z = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[z] = bucket[j][k];
                z++;
            }
        }
        System.out.println("第三轮处理后的数据" + Arrays.toString(array));
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }


//第四轮: 从千位开始:
        //向桶中存数据，从数组向桶中存数据
        for (int i = 0; i < array.length; i++) {
            int mod = 1 * 10;
            int division = 1 * 10*10*10;
            int element = array[i] / division % mod;
            bucket[element][bucketElementCounts[element]] = array[i];
            bucketElementCounts[element]++;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].length; j++) {
                System.out.print(bucket[i][j] + " ");
            }
            System.out.println();
        }
        //从桶中取数据，将数据放置到数组中
        int zz = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[zz] = bucket[j][k];
                zz++;
            }
        }
        System.out.println("第二轮处理后的数据" + Arrays.toString(array));
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }*/


    }
}