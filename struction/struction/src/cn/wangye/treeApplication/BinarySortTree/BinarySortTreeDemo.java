package cn.wangye.treeApplication.BinarySortTree;

//重新写一遍
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2,11};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            binarySortTree.add(new Node(array[i]));
        }
        System.out.println("开始查找值为value的节点");
        System.out.println(binarySortTree.searchNode(5));
        System.out.println("开始查找值为value的父节点");
        System.out.println(binarySortTree.searchParentNode(5));
        System.out.println("~~~删除节点~~~");
        binarySortTree.deleteValueNode(5);
        binarySortTree.deleteValueNode(10);
        binarySortTree.deleteValueNode(3);
        binarySortTree.deleteValueNode(9);
        binarySortTree.deleteValueNode(1);
        binarySortTree.deleteValueNode(100);
        binarySortTree.deleteValueNode(7);
        System.out.println("删除后的中序遍历开始了~");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    /**
     * 删除值为Value的节点;
     *
     * @param value 值为Value的节点
     *              思路：
     *              1.找到待删除的节点
     *              2.找到待删除节点的父节点
     *              3.根据待删除节点的类型和子父节点的关系，判断进行删除操作的类型;
     *              a.待删除节点为叶子节点 判断是左叶子节点还是右叶子节点设置成null即可；
     *              b.待删除的节点为单子树 判断是父节点的左子树还是右子树，左子树的话,继续向下递归到最大值，复制，当待删除节点的值改变；右的话寻找最小值。
     *              c.非叶子节点，随意了;
     */
    public void deleteValueNode(int value) {
        if (root == null){
            return ;
        }
        Node foundNode = searchNode(value);
        Node foundParentNode = searchParentNode(value);
        if (foundNode == null) {
            System.out.println("删除失败,找不到删除节点");
            return;
        } else {
            if (foundParentNode == null) {
                deletedNonLeafNode(foundNode);
//                Node relativedMaxNode = searchRightTreeMaxNode();
//                root.value = relativedMaxNode.value;
//                Node maxParentNode = searchParentNode(relativedMaxNode.value);
//                if (maxParentNode.left == relativedMaxNode) {
//                    maxParentNode.left = null;
//                } else {
//                    maxParentNode.right = null;
//                }
//                此时节点的最小值是没有删除的，之后我们需要当成叶子节点进行删除;
            } else {
//                这里进行三个条件的判断;
//                foundNode为叶子节点
                if (foundNode.left == null && foundNode.right == null) {
                    if (foundParentNode.left == foundNode) {
                        foundParentNode.left = null;
                    } else {
                        foundParentNode.right = null;
                    }
                }
//                foundNode为单子节点
                if (foundNode.left == null || foundNode.right == null) {
                    if (foundParentNode.left == foundNode && foundNode.left != null) {
                        foundParentNode.left = foundNode.left;
                    } else if (foundParentNode.right == foundNode && foundNode.left != null) {
                        foundParentNode.right = foundNode.left;
                    } else if (foundParentNode.left == foundNode && foundNode.right != null) {
                        foundParentNode.left = foundNode.right;
                    } else if (foundParentNode.right == foundNode && foundNode.right != null) {
                        foundParentNode.right = foundNode.right;
                    }
                }
//               foundNode为双子节点,这里并不是删除，而是进行赋值的操作;
                if (foundNode.left != null && foundNode.right != null) {
                    deletedNonLeafNode(foundNode);
                }
            }
        }

    }

    /**
     * 直接删除非叶子节点，并将非叶子节点的右子树的最小值作为树节点
     * @param deletedNode 待删除的节点
     */
    public void deletedNonLeafNode(Node deletedNode){
        Node relativedMaxNode = deletedNode.right;
        while (true) {
            if (relativedMaxNode.left == null) {
                break;
            }
            relativedMaxNode = relativedMaxNode.left;
        }
        deleteValueNode(relativedMaxNode.value);
//      我们在树中先把relativeMaxNode对应的节点给删除了;
//        Node relativedMaxParentNode = searchParentNode(relativedMaxNode.value);
//
//        if (relativedMaxParentNode.left == relativedMaxNode) {
//            relativedMaxParentNode.left = null;
//        } else {
//            relativedMaxParentNode.right = null;
//        }
        deletedNode.value = relativedMaxNode.value;
    }





    public Node searchParentNode(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public Node searchNode(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }


    //    书写一个添加的二叉排序树节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }


    //    书写一个遍历二叉排序树的方法
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("此二叉树为空");
        }
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 根据值进行节点的查找:
     *
     * @param value 带查找节点的值
     * @return 为value的节点
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        if (this.value > value) {
            if (this.left != null) {
                return this.left.search(value);
            }
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
        }
        return null;
    }

    /**
     * 根据value,查找对应的父节点;
     * @param value 待查找值
     * @return 返回节点
     * 如果为返回值为null,就说明查找到的是root节点。
     */
    public Node searchParent(int value) {
//        注意，这里可能出在没有父节点的情况，就比如root节点 只有根节点才不存在父节点。
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            } else if (this.right != null && this.value < value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }


    //    这里我们编写删除节点的方法:
    /*
     * 差的并不是Java语言语法层面的东西，而是对于问题拆解的思维;
     * 删除二叉树的特定节点后，二叉树的结构不变。
     *
     * 所以我们需要两个以上的指针，才可以完成相关的操作。
     * 我们删除结点，仅仅是该节点，如果这一个节点非叶子节点的话，我们需要进行其他二叉树节点的补充。而不是直接将所有的节点都删除。
     *
     * */


    /**
     * 这是一个错误的示范，我们不能改变this自身的指向。
     *
     * @param ”targetNode“ 目标节点
     *                     在Java中，不能对this进行赋值操作，因为它是一个隐式的、不可修改的参数。
     *                     在方法内部，你可以通过this引用来访问对象的成员，但无法更改this本身所指向的对象。
     *                     因此，这行代码会导致编译错误。
     */
/*
    public void delete(Node targetNode) {
//        方法对于时候删除有一点重复
        Node temp = this;
//        先比较当前节点是否是要查询的节点
        if (this.value == targetNode.value) {
//            this不呢个直接设置成null值;
            this = null;
            return;
        } else {
            if (this.value > targetNode.value && this.left != null) {
//                if (this.left.value == targetNode.value) {
//                    this.left = null;
//                }
                this.left.delete(targetNode);
            }else{
                if (this.right.value == targetNode.value){
                    this.right = null;
                }
                this.right.delete(targetNode);
            }
        }

    }*/


    //    这里我们编写一个递归插入节点的方法;
    public void add(Node waitNode) {
        if (waitNode == null) {
            return;
        }
        if (this.value > waitNode.value) {
            if (this.left == null) {
                this.left = waitNode;
            } else {
                this.left.add(waitNode);
            }
        } else {
            if (this.right == null) {
                this.right = waitNode;
            } else {
                this.right.add(waitNode);
            }
        }
    }

    //    这里编写二叉树中序遍历的方法:
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this.value);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
};