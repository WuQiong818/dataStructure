package cn.wangye.stack;

import java.util.Arrays;
import java.util.Scanner;

public class stackArrayDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean flag =true;
        while (flag) {
            System.out.println("a一个添加的数");
            System.out.println("p一个出栈的数");
            System.out.println("s进行查询");
            System.out.println("e进行退出操作");
            key = (sc.next().charAt(0));
            switch (key) {
                case 'a':
                    System.out.println("请输入一个添加的数");
                    arrayStack.push(sc.nextInt());
                    break;
                case 'p':
                    arrayStack.pop();
                    break;
                case 's':
                    arrayStack.showAll();
                    break;
                case 'e':
                    flag =false;
                    sc.close();
                    break;
            }
        }
        System.out.println("程序结束，再见了");
    }
}

class ArrayStack {
    private int[] stack;
    private int top = -1;

    private int length;

    public ArrayStack() {
    }

    public ArrayStack(int length) {
        this.length = length;
        this.stack = new int[this.length];
    }

    @Override
    public String toString() {
        return "stack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                ", length=" + length +
                '}';
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public boolean isFull() {
        return top == length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //定义出栈操作，pop()方法:
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈已满，请进行出栈操作后继续");
            return;
        }
        top++;
        stack[top] = num;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("栈已空，请添加后重试吧!");
            return;
        }
        System.out.println("本次出栈的数是" + stack[top]);
        top--;
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("栈已空");
        }
        for (int i =top;i>=0;i--){
            System.out.println("查询的top值为" + i + "值为" + stack[i]);
        }
    }
}

