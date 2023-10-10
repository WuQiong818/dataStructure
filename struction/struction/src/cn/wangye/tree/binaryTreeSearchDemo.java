package cn.wangye.tree;

public class binaryTreeSearchDemo {
    public static void main(String[] args) {
        //现在这里有一点困惑，我是直接把所有的准备工作的做好，在开始new 对象，还是按着程序执行的顺序，一点一点地写呢
        //先写最基础的HeroNode类。
        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "林冲");
        HeroNode heroNode4 = new HeroNode(4, "武松");
        HeroNode heroNode5 = new HeroNode(5, "鲁智深");
        HeroNode heroNode6 = new HeroNode(6, "6");
        HeroNode heroNode7 = new HeroNode(7, "7");
        HeroNode heroNode8 = new HeroNode(8, "8");

        binaryTree.setRoot(heroNode1);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
//        heroNode2.setLeft(heroNode6);
//        heroNode2.setRight(heroNode7);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);
//        heroNode7.setRight(heroNode8);

//    binaryTree.preOrder();
//    System.out.println("--------");
//    binaryTree.infixOrder();
//    System.out.println("--------");
//    binaryTree.postOrder();
        System.out.println("二叉树查找算法开始了");
        //前序查找
/*        HeroNode node = binaryTree.preOrderSearch(56);
        if (node != null) {
            System.out.println(node);
        } else {
            System.out.println("找不到");
        }*/

/*        //中序查找
        HeroNode node = binaryTree.infixOrderSearch(5);
        if (node != null) {
            System.out.println(node);
        } else {
            System.out.println("找不到");
        }*/


        //后序查找
        HeroNode node = binaryTree.postOrderSearch(5);
        if (node != null) {
            System.out.println(node);
        } else {
            System.out.println("找不到");
        }
        //
        binaryTree.deleteNode(3);

        HeroNode node1 = binaryTree.postOrderSearch(5);
        if (node1 != null) {
            System.out.println(node1);
        } else {
            System.out.println("找不到");
        }
    }
}

class BinaryTree {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("root阶段为空！");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("root阶段为空！");
        }
    }


    public HeroNode preOrderSearch(int findValue) {
        if (this.root != null) {
            return this.root.preOrderSearch(findValue);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int findValue) {
        if (this.root != null) {
            return this.root.infixOrderSearch(findValue);
        } else {
            return null;
        }
    }
    public HeroNode postOrderSearch(int findValue) {
        if (this.root != null) {
            return this.root.postOrderSearch(findValue);
        } else {
            return null;
        }
    }

    public void deleteNode(int no) {
        if (this.root != null) {
            this.root.deleteNode(no);
        } else {
            System.out.println("树为空");
        }
    }

}


class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //先输出父节点，在输出左节点和右节点
    public void preOrder() {
        //这里要么传入一个参数，要么就使用this的指向，this指向调用者，第一次执行的时候，也就是指向前面的root;
        System.out.println(this.no);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        //这里要么传入一个参数，要么就使用this的指向，this指向调用者，第一次执行的时候，也就是指向前面的root;
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.no);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        //这里要么传入一个参数，要么就使用this的指向，this指向调用者，第一次执行的时候，也就是指向前面的root;
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this.no);
    }


    //这一个在二叉树里面进行递归查找挺有意思的。

    //在这一个方法中，递归因两种方式而结束，
    // 1、找到值了2.
    // 没找到，从左树，穷尽到了右树。

    public HeroNode preOrderSearch(int findValue) {
        System.out.println(1);
        if (findValue == this.no) {
            return this;//
        }
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.preOrderSearch(findValue);//有两个结果，如果找到了，处理一下
        }
        //在左递归回溯的时候处理值。
        //-----------------------------------
        //一定要写这一个式子，这个式子保证了左递归找到值的情况下，立即返回;
        //左递归没有找到值的情况下，正常进行右递归;
        //如果没有这一个式子，这段程序该是这样运行的:
        // 程序将最左边的树全部遍历了,没有找到值的话，就直接返回，不会再进行右遍历了
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(findValue);
        }
        return result;//这个是不管右递归找到没找到，只要出现this.right=null的情况，都需要向上传值。
    }

    public HeroNode infixOrderSearch(int findValue) {
        HeroNode result = null;
        if (this.left != null) {
            //这里不能直接写return,不然只会遍历最左边的树
            result = this.left.infixOrderSearch(findValue);
        }
        //这里如果在左递归的时候，缺少对result的判断，会在找到到值的情况下，再次覆盖；
        if (result!=null){//这个式子的目的，就是找到到值了，终止递归，直接进行向上回溯
            return result;
        }

        System.out.println("进入中序查找");
        if (this.no == findValue) {
            return this;
        }

        if (this.right != null) {
             result =  this.right.infixOrderSearch(findValue);//这个其实无所谓，直接返回也可以，在这是在前序和中序的情况下
        }
        System.out.println("执行不到这里");
        return result;
    }


    public HeroNode postOrderSearch(int findValue) {
        HeroNode result = null;

        if (this.left != null) {
            result = this.left.postOrderSearch(findValue);
        }

        if (result!=null){
            return result;
        }

        if (this.right != null) {
            result =  this.right.postOrderSearch(findValue);//这个其实无所谓，直接返回也可以，在这是在前序和中序的情况下
        }
        if (result!=null){
            return result;
        }

        System.out.println("进入后序查找");
        if (this.no == findValue) {
            return this;
        }

        return null;
    }

    public void deleteNode(int no) {
        //由于链表是单向的，所以需要有两个变量来控制（这个逻辑可以简化，不需要有temp，直接用this和this.left就可以了）
        /*HeroNode temp = null;
        if (this.left!=null){
            temp this= .left;
            if (temp.no==no){//
                this.left = null;
                System.out.println("已删除"+temp);
                return;
            }
            this.left.deleteNode(no);
        }*/

        if (this.left != null && this.left.no == no) {//当前节点的左子节点不为空，并且左子节点的no=删除的no
            System.out.println("已删除" + this.left);
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {//当前节点的左子节点不为空，并且左子节点的no=删除的no
            System.out.println("已删除" + this.right);
            this.right = null;
            return;
        }
        if (this.left !=null){
            this.left.deleteNode(no);
        }
        if (this.right!=null){
            this.right.deleteNode(no);
        }
        //执行到这里，不管有没有返回值，返回条件，递归都会终止。
        //这里仍然是有递归终止的条件的，只不过隐藏起来的，只有递归的左节点和右节点都为空，递归才会终止，隐含的
        /*
        * 这一个遍历树的递归，终止条件有三个
        * 1.在左遍历中找到了自己要删除的节点
        * 2.在右遍历中找到了自己要删除的节点
        * 3.左右节点都为空，只有都为空的，才会向上回溯，通过不断地递归，回溯，递归，回溯，将整个二叉树遍历完
        * 算法结束。所以，这里就出现了一个问题，没有找到删除节点的信息都不好往上面添加。
        *
        * */

    }
}
