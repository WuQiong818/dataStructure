package cn.wangye.treeApplication.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffman(arr);
        //为了检验我们的赫夫曼树，我们进行前序遍历，进行检查:
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.preOrder(root);
    }

    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空,不能进行遍历");
        }
    }

    public static Node createHuffman(int[] arr) {
        /*
         * 第一步：为了操作方便
         * 1.先遍历arr数组
         * 2.将arr的每一个元素构成一个Node
         * 3.将Node放入到ArrayList中
         * */
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        /*
         * 第二步:进行父节点的创建
         * 1.对nodes中的节点进行排序
         * 2.取出最小的节点作为左子节点
         * 3.取出次小的节点作为右子节点
         * 4.构建共同的父节点
         * //这是一个循环的过程，在这里我们需要不断进行重复的操作，直到nodes.size()=1
         * */
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
}


/*
 * 我们在构建赫夫曼树的过程中，需要经常对树中的权值进行排序
 * 所以我们需要实现Comparable结构，来方便进行排序
 * */
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        //排序，从小到大进行排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
