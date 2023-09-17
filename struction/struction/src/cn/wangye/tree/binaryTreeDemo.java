package cn.wangye.tree;

public class binaryTreeDemo {
    public static void main(String[] args) {
        //现在这里有一点困惑，我是直接把所有的准备工作的做好，在开始new 对象，还是按着程序执行的顺序，一点一点地写呢

        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "林冲");
        HeroNode heroNode4 = new HeroNode(4, "武松");
        HeroNode heroNode5 = new HeroNode(5, "鲁智深");
        binaryTree.setRoot(heroNode1);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);
        binaryTree.preOrder();
        System.out.println("--------");
        binaryTree.infixOrder();
        System.out.println("--------");
        HeroNode node = binaryTree.preOrderSearch(5);
        if (node!=null){
            System.out.println(node);
        }else {
            System.out.println("找不到该值");
        }

    }
}

/*class BinaryTree {
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

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("root阶段为空！");
        }
    }

}*/


/*class HeroNode {
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
    }*/
//}
