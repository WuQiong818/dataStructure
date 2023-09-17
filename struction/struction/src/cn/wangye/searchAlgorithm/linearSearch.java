package cn.wangye.searchAlgorithm;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int fondValue = 0;
        int index = seqSearch(arr, fondValue);
        if (index==-1){
            System.out.println("没有找到该数");
        }else{
            System.out.println(fondValue+"该数的下标是"+index);
        }
    }

    private static int seqSearch(int[] arr, int fondValue) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==fondValue){
                index = i ;
                break;
            }
        }
        return index;
    }
}
