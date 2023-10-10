package cn.wangye.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历开始了");
        arrBinaryTree.preOrder();
        System.out.println("中序遍历开始了");
        arrBinaryTree.infixOrder();
        System.out.println("后序遍历开始了");
        arrBinaryTree.postOrder();
    }
}
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //这里进行方法重载，目的是保证数组的遍历是从arr开始的
    public void preOrder(){
        preOrder(0);
    }
    public void infixOrder(){
        infixOrder(0);
    }public void postOrder(){
        postOrder(0);
    }

    public void preOrder(int index){
        if (arr == null||arr.length ==0){
            System.out.println("数组为空，不能进行遍历");
        }
        System.out.print(arr[index]+" ");
        //左递归开始了
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
    public void infixOrder(int index){
        if (arr == null||arr.length ==0){
            System.out.println("数组为空，不能进行遍历");
        }
        if (index*2+1< arr.length){
            infixOrder(index*2+1);
        }

        System.out.print(arr[index]+" ");

        if (index*2+2< arr.length){
            infixOrder(index*2+2);
        }
    }

    public void postOrder(int index){
        if (arr == null||arr.length ==0){
            System.out.println("数组为空，不能进行遍历");
        }

        if (index*2+1< arr.length){
            postOrder(index*2+1);
        }

        if (index*2+2< arr.length){
            postOrder(index*2+2);
        }

        System.out.print(arr[index]+" ");
    }
}