package cn.wangye.tree.threadedBinaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

//        准备工作
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(3, "吴用");
        HeroNode heroNode3 = new HeroNode(6, "林冲");
        HeroNode heroNode4 = new HeroNode(8, "武松");
        HeroNode heroNode5 = new HeroNode(10, "鲁智深");
        HeroNode heroNode6 = new HeroNode(14, "李逵");
        threadedBinaryTree.setRoot(heroNode1);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);
        threadedBinaryTree.threadedBinaryMethod();
        threadedBinaryTree.threadedList();
      /*  System.out.println("前驱结点");
        System.out.println(heroNode5.getLeft().getNo());
        System.out.println("后继结点");
        System.out.println(heroNode5.getRight().getNo());*/
//      对线索化的二叉树进行中序遍历，对二叉树一旦进行线索化之后，之前所编写的中序遍历就不可以用了，用之前的对导致一个死循环。




    }
}
