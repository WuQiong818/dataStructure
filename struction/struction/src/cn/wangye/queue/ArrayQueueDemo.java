package cn.wangye.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        Scanner sc = new Scanner(System.in);
        String key ="";
//        String key = sc.next();
        boolean loop = true;
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("h:显示头部队列");
            System.out.println("g:获取队列中头部的数据");
            System.out.println("a:向队列中添加数值");
            System.out.println("e:退出程序");
            System.out.println("请输入您的操作");
            key=sc.next();
            switch (key) {
                case "s":
                    queue.showQueue();
                    break;
                case "h":
                    int res = queue.showHeadQueue();
                    System.out.println(res);
                    break;
                case "a":
                    System.out.println("请输入添加的数据");
                    int num = sc.nextInt();
                    queue.addQueue(num);
                    break;
                case "g":
                    int number=queue.getQueue();
                    System.out.println(number);
                    break;
                case "e":
                    sc.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序运行结束了");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }
/*            boolean flag=false;
        if (front==rear){
            flag = true
        }
        return flag;
这个地方是可以变得更加精简的，直接返回值，在返回之前直接进行条件的判断,不然代码就变得更加地复杂了，不需要这么复杂；*/

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //添加数据到队列当中；
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能进行添加操作");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //从队列中取数据，依次出队;
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //获取队列中所有的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有任何数据，请添加数据后再尝试");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，请添加数据");
        }
        //这里并没有进行赋值的操作，不论这个方法执行了多少次，都对front的大小没有产生任何的影响；
        return arr[front + 1];
    }
}
