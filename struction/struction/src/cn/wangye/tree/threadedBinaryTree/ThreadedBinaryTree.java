package cn.wangye.tree.threadedBinaryTree;


public class ThreadedBinaryTree {

    private HeroNode root;

    private HeroNode pre = null;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedBinaryMethod() {
        threadedBinaryMethod(this.root);
    }

    public void threadedBinaryMethod(HeroNode node) {

        //之前在这里写下pre = null,导致二叉树没有进行线索化，
        //既然pre是作为指针而存在的，就应该放到方法的外边，作为全局变量来协调

        if (node == null) {
            return;
        }
        //这里先进行中序二叉树的线索化，要形成一个循环或者递归。
            //1.先线索化左子树
            threadedBinaryMethod(node.getLeft());
            //2.线索化当前节点
            //2.1 处理当前节点的前驱节点
            if (node.getLeft() == null) {
                node.setLeft(pre);
                node.setLeftType(1);
            }
            //2.2 处理当前节点的后继节点
            //当我们处理后继节点的时候，为什么需要进行如下的条件判断。原因:只有节点为空，我才进行线索化的
            if (pre != null && pre.getRight() == null) {
                pre.setRight(node);
                pre.setRightType(1);
            }
            //2.3 进行节点的变化和位移
            pre = node;
            //3.线索化右子树
            threadedBinaryMethod(node.getRight());
        }

        public void threadedList() {
            //遍历二叉树一定是从根上面开始的
            HeroNode node = root;
            if (node == null) {
                System.out.println("二叉树为空，不能进行遍历");
                return;
            }
            while (node != null) {
                //遍历左子树
                while (node.getLeftType() == 0) {
                    node = node.getLeft();
                }
                //处理当前节点
                System.out.println(node.getNo());

                while(node.getRightType()==1){
                    node = node.getRight();
                    System.out.println(node.getNo());
                }
//                我在这里写遍历右子树的时候实际上又陷入了一次循环当中，需要看看左边的，在看看右边的，也就是和前面的逻辑一样了
                //遍历右子树
//                while(node.getRight()!=null){
//                    node = node.getRight();
//                    System.out.println(node.getNo());
//                }
                node = node.getRight();//二叉树终止于右结点为null
            }
        }
}
