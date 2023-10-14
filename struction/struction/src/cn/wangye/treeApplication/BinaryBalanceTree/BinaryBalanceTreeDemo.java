package cn.wangye.treeApplication.BinaryBalanceTree;


public class BinaryBalanceTreeDemo {
    public static void main(String[] args) {
        BinaryBalanceTree binaryBalanceTree = new BinaryBalanceTree();
        binaryBalanceTree.infixOrder();
//        int[] array = {4, 3, 6, 5, 7, 8};
//        int[] array = {7, 4, 3, 6, 8, 5};
        int[] array = {10, 11, 7, 6, 8, 9};
        for (int j : array) {
            binaryBalanceTree.add(new Node(j));
        }
        System.out.println("左子树的高度" + binaryBalanceTree.root.getLeftHeight());
        System.out.println("右子树的高度" + binaryBalanceTree.root.getRightHeight());
        System.out.println("插入后的中序遍历结果");
        binaryBalanceTree.infixOrder();
        System.out.println("根节点的左节点"+binaryBalanceTree.root.left);
        System.out.println("根节点的右节点"+binaryBalanceTree.root.right);
    }
}

class BinaryBalanceTree {
    Node root = null;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("根节点为空~");
        } else {
            root.infixOrder();
        }
    }
}


class Node {
    int value;
    Node left;
    Node right;
    //   树的高度设置一定是在节点添加的时候进行设置的，这样添加会比较舒服;
    int leftHeight = 0;
    int rightHeight = 0;

    public int getLeftHeight() {
        if (left == null) {
            return 0;
        }
        return left.computeHeight();
    }

    public int getRightHeight() {
        if (right == null) {
            return 0;
        }
        return right.computeHeight();
    }

    //不学习你真的写不出来这样的式子，太强了!
    public int computeHeight() {
        return Math.max(left == null ? 0 : left.computeHeight(), right == null ? 0 : right.computeHeight()) + 1;
    }


    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftHeight=" + leftHeight +
                ", rightHeight=" + rightHeight +
                '}';
    }


    public void add(Node node) {
//        这里是存在一个this的指向问题的,this永远都指向方法的调用者。
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
//        System.out.println("value=" + value);
//        遍历root的子树，会返回那一边的非叶子节点;
//        右边>左边，进行左旋操作
        /*
         * 这里存在一个问题,我们需要在判断时候需要左旋转、右旋转的时候，在增加一个条件的判断；
         * 因为我们的右旋转的时候，是直接将当前节点的左子树的右节点拼接给新节点的左节点。
         * 如果我们的左子树的左节点的高度小于左子树的右节点的高度，会导致旋转过后右子树的高度大于左子树。
         * 所以，我们需要继续一个条件的判断，是否需要在右旋转之前，是否进行进行做子树的有左旋转。
         * */

        if (getRightHeight() - getLeftHeight() > 1) {
            if (right != null && right.getLeftHeight() > right.getRightHeight()) {
                right.rightRotate();
            }
            leftRotate();
        } else if (getLeftHeight() - getRightHeight() > 1) {
            if (left != null && left.getRightHeight() > left.getLeftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    //        这里 一般添加玩之后，我们需要进行判断是否需要进行左右旋转来调整二叉树。
    //        什么情况下，我们需要调整二叉树呢？判断每一个非叶子节点的左右二叉树的高度相差是否大于1;
    public void leftRotate() {
//        创建一个值为当前节点的新节点
        Node newNode = new Node(value);
//新节点的左子树指向原来节点的左子树
        newNode.left = left;
//        新节点的右子树指向原来节点右子树的左子树
        newNode.right = right.left;
//        将当前节点的右子树的值，赋值给当前节点
        value = right.value;
//      右子树指向当前节点右子树的右子树
        right = right.right;
//        当前节点的左子树指向新节点
        left = newNode;
    }

    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }


    //    写一个中序遍历的方法;
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
