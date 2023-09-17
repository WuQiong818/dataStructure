package cn.wangye.linkedList.doubleLinkedList.singleLinkedList;

public class JosePhu {
    public static void main(String[] args) {
        CircleLinkedList circleList = new CircleLinkedList();
        circleList.createCircleLinkedList(13);
//        circleList.showList();
        circleList.overBound(13,3,5);
    }
}
class CircleLinkedList {
    Kid first = null;
    public void overBound(int n,int start ,int count){
        if (first==null||start<1||count>n){
            System.out.println("输入的参数有误");
            return;
        }
        Kid helper = first;
        do {
            helper=helper.getNext();
        }while(helper.getNext()!=first);
        //在数数出圈之前，先移动几个单位
        for (int i=1;i<=start-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
         do{
            //开始出圈了
            for (int j = 1; j <= count-1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈的编号是" + first.getId());
            first = first.getNext();
            helper.setNext(first);//helper进行出圈的操作，直接跳过出圈点
        }while(first!=helper);
         System.out.println("最后一个出圈的是"+first.getId());
    }
    public void createCircleLinkedList(int n) {
        Kid temp = null;
        if (n<1) {
            System.out.println("请输入大于或等于1的编号");
            return;
        }
        for (int i =1;i<=n;i++){
            //通过for循环进行节点的创建
            Kid kid = new Kid(i);
            if (i ==1){
                first = kid;
                first.setNext(first);
                temp =first;
            }else{
                kid.setNext(first);
                temp.setNext(kid);
//                temp.setNext(temp.getNext());//这一个制造了一个自身的循环temp.next =temp.next;
                temp = temp.getNext();
            }
        }
    }
    public void showList(){
        Kid temp = first;
//        这个循环体会导致最后一个没有输出；上一个循环体执行了temp.next=last时，
//        再次判断条件会导致temp.next = first用do while
//        while(!(temp.getNext()==first)){
//            System.out.println(temp.getId());
//            temp=temp.getNext();
//        }
        do {
            System.out.println(temp.getId());
            temp=temp.getNext();
        }while (!(temp==first));
    }
}

class Kid {
    private int id;
    private Kid next;

    public Kid() {
    }

    public Kid(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kid getNext() {
        return next;
    }

    public void setNext(Kid next) {
        this.next = next;
    }
}