package four;

public class P69 {

    public static void main(String[] args) {
        /*1.直接计算出圈人的下标，进行打印输出；自己加上固定的人数，超过目前已有的人数时，下标回归于0；
        * 2.输出出圈人后，将出圈人后面的数组元素前移
        *算法真厉害，佩服佩服，尤其是第18行，简直就是艺术，以后if和while要判断清楚；
        * */
        int n=13,s=3,m=5;
        int [] array =new int[n];
        int leave=s-1;
        for (int i =1;i<=array.length;i++){
            array[i-1]=i;
        }
        for (int i = 0;i<array.length;i++){
            leave+=m-1;
            while(leave>=n){
                leave-=n;
            }
            System.out.print(array[leave]+" ");
            //输出一个数组元素后，会给输出元素后面的数组部分进行重排；
            for (int j =leave;j<n-1;j++){
                array[j]=array[j+1];
            }
            n--;
        }



    }
}




/*        *//*
          自己想的没有解出：
         * 约瑟夫环问题，使用数组进行解决：
         * 分析：
         * 1.三个重要的变量 总人数n 开始报数的序号s 出列的数m;
         * 2.剔除的序号如何进行处理,他原先的占位如何处理；利用数组进行处理，已出圈的序号，往后面排；
         *
         *  3.报数的人数递减，应该有一个计量数--遍历数组的范围；
         * *//*

        int n=13,s=3-1,m=5;
        int exit=s+1;
        int [] array =new int[n];
        int count =0;
        for (int i =1;i<=array.length;i++){
        array[i-1]=i;
        }

        for (int j=array.length-1;j>=0;j--){
        for(int k=0;k<m;k++){
        if (count+k>=j){
        count-=12;
        }
        exit=array[s+k];
        }
        count+=4;
        //这里需要进行一次数组的变换，或者是元素的删除

        System.out.print(exit+" ");*/
