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
        //�Լ���д��������
        //*��һ��:�ȵõ�����������ȡ�������λ��
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();

        //*�ڶ���������׼�������������ô������Ͱ�ͼ�¼ÿһ��Ͱ��Ԫ�ظ���������
        int[][] bucket = new int[10][array.length];
        int[] bucketElementCount = new int[10];
        int division = 1;

        //*������:���������㷨:����Ͱ�У���Ͱ��ȡ����;
        for (int i = 0; i < maxLength; i++) {
            if (i != 0) {
                division *= 10;
            }
            //(3.1)��������ȡ���ݣ���Ͱ�з�����;
            for (int j = 0; j < array.length; j++) {
                int element = array[j] / division % 10;
                bucket[element][bucketElementCount[element]] = array[j];
                bucketElementCount[element]++;
            }
            int index = 0;
            //(3.2)��Ͱ��ȡ���ݣ���Ͱ�з�����,˳����Ͱ�����Ͱ���������������
            for (int x = 0; x < bucket.length; x++) {
                for (int y = 0; y < bucketElementCount[x]; y++) {
                    array[index] = bucket[x][y];
//                    bucket[x][y] = 0;//��һ��Ͱ�������ö�����,��Ϊѭ�����������ŵģ����Բ���Ӱ��֮��ĸ�ֵ��ȡֵ
                    index++;
                }
                bucketElementCount[x]=0;//�����¼����Ͱ�����ݵĸ��������飬һ��Ҫ���á�
            }
        }












/*        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();//������õ���������������λ��;
        int[][] bucket = new int[10][array.length];//����һ����ά���飬�еĳ���Ϊ10��������ʾʮ��Ͱ����0��9,�еĳ���Ϊ����ĳ��ȣ�ȷ���κ������±궼��Խ��.
        int[] bucketElementCounts = new int[10];//����һ�����飬������ʾ����Ͱ���Ѿ�װ�����ݵĸ������������ݵĴ�ȡ;

        //�����оٵķ���,�Ӹ�λ��ʮλ����λ��һλһλ��������;
        //��һ��: �Ӹ�λ����:
        //��Ͱ�д����ݣ���������Ͱ�д�����
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
        //��Ͱ��ȡ���ݣ������ݷ��õ�������
        int x = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[x] = bucket[j][k];
                x++;
            }
        }
        System.out.println("��һ�ִ���������" + Arrays.toString(array));
        //�����������ã�������һ�����ݵ�ʹ��
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }
        //�ڶ���: ��ʮλ��ʼ:
        //��Ͱ�д����ݣ���������Ͱ�д�����
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
        //��Ͱ��ȡ���ݣ������ݷ��õ�������
        int y = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[y] = bucket[j][k];
                y++;
            }
        }
        System.out.println("�ڶ��ִ���������" + Arrays.toString(array));
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }

        //�����оٵķ���,�Ӹ�λ��ʮλ����λ��һλһλ��������;
        //������: �Ӱ�λ����:
        //��Ͱ�д����ݣ���������Ͱ�д�����
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
        //��Ͱ��ȡ���ݣ������ݷ��õ�������
        int z = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[z] = bucket[j][k];
                z++;
            }
        }
        System.out.println("�����ִ���������" + Arrays.toString(array));
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                bucket[i][j] = 0;
            }
        }


//������: ��ǧλ��ʼ:
        //��Ͱ�д����ݣ���������Ͱ�д�����
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
        //��Ͱ��ȡ���ݣ������ݷ��õ�������
        int zz = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            for (int k = 0; k < bucketElementCounts[j]; k++) {
                array[zz] = bucket[j][k];
                zz++;
            }
        }
        System.out.println("�ڶ��ִ���������" + Arrays.toString(array));
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