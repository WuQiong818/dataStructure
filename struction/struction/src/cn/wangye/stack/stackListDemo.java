package cn.wangye.stack;

import java.util.Scanner;

/*
 * 1.出栈的顺序应该是从向前
 * 2.出栈之后的数，仍然可以遍历到
 * 3.为空的判断，直接报错了
 * */
public class stackListDemo {
    public static void main(String[] args) {
        StackList stackList = new StackList();
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean flag = true;
        /*很脆弱，有一点小bug,空的条件判断·*/
        while (flag) {
            System.out.println("a一个添加的数");
            System.out.println("p一个出栈的数");
            System.out.println("s进行查询");
            System.out.println("e进行退出操作");
            key = (sc.next().charAt(0));
            switch (key) {
                case 'a':
                    System.out.println("请输入一个添加的数");
                    int number = sc.nextInt();
                    stackList.push(new listNode(number, null, null));
                    break;
                case 'p':
                    stackList.pop();
                    break;
                case 's':
                    stackList.showAll();
                    break;
                case 'e':
                    flag = false;
                    sc.close();
                    break;
            }
        }
        System.out.println("程序结束，再见了");
    }
}


class StackList {
    listNode head = new listNode(0, null, null);
    listNode temp = head;

    public boolean isEmpty() {
        return head == temp;
    }

    public void push(listNode node) {
        node.pre = temp;
        temp.next = node;
        temp = temp.next;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("栈为空，请添加后在进行操作吧！");
            return;
        }
        System.out.println("出栈的数据为" + temp.data);
        temp = temp.pre;
    }

    public void showAll() {
        //我要的是遍历，不是出栈，所以还是需要一个临时的指针去帮助遍历一遍；
        if (isEmpty()) {
            System.out.println("栈为空，请添加后在进行操作吧！");
            return;
        }
        listNode index = temp;
        int count = 1;
        while (index != head) {
            System.out.println("第" + count + "为" + index.data);
            index = index.pre;
            count++;
        }
    }
}

class listNode {
    public int data;
    public listNode next;
    public listNode pre;

    public listNode() {
    }

    public listNode(int data, listNode next, listNode pre) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "listNode{" +
                "data=" + data +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}