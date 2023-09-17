package cn.wangye.queue;

import java.util.Scanner;

public class circleArrayDemo {
    public static void main(String[] args) {
        circleArray queue = new circleArray(5);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("h:显示头部队列");
            System.out.println("g:获取队列中头部的数据");
            System.out.println("a:向队列中添加数值");
            System.out.println("e:退出程序");
            System.out.println("请输入您的操作");
            char key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.showHeadQueue();
                        System.out.println(res);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'a':
                    System.out.println("请输入添加的数据");
                    int num = sc.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int number = queue.getQueue();
                        System.out.println(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }
        System.out.println("程序运行结束了");
    }
}

class circleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public circleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * isFull方法的解析
     *
     * @return 这里之所以取模的原因是因为我们需要知道一个循环体，%本身就可以构
     * 成一个小循环，比如：以5为单位进行取模，如何一个数都可以循环成0到4之间的数字
     * 现在存在一个疑问，这个空白单位是否可以去除，可以自己测试一下？？？
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //添加数据到队列当中；
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能进行添加操作");
            return;
        }
        arr[rear] = n;
        rear=(rear+1)%maxSize;
    }

    //从队列中取数据，依次出队;
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }

    //获取队列中所有的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有任何数据，请添加数据后再尝试");
        } else {
            for (int i = front; i < front+size(); i++) {
                System.out.println("arr["+i+"]=" + arr[i%maxSize]);
            }
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，请添加数据");
        }
        //这里并没有进行赋值的操作，不论这个方法执行了多少次，都对front的大小没有产生任何的影响；
        return arr[front];
    }
}
