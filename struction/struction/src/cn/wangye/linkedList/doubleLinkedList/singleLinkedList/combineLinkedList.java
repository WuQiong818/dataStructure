package cn.wangye.linkedList.doubleLinkedList.singleLinkedList;

public class combineLinkedList {
    public static void main(String[] args) {
//        HeroNode heroNode1 = new HeroNode(1, "11", "及时雨");
//        HeroNode heroNode2 = new HeroNode(2, "22", "智多星");
//        HeroNode heroNode3 = new HeroNode(3, "33", "豹子头");
//        HeroNode heroNode4 = new HeroNode(4, "44", "行者");
//        HeroNode heroNode5 = new HeroNode(5, "鲁55", "花和尚");
//        HeroNode heroNode6 = new HeroNode(6, "卢66", "玉麒麟");
//        HeroNode heroNode7 = new HeroNode(7, "77", "入云龙");
//        HeroNode heroNode8 = new HeroNode(8, "88", "白老虎");
////这里之所以如此不同，根本原因在于提前new好的对象，指向了同一个地址栏；
        singleLinkedList linkedList1 = new singleLinkedList();
        linkedList1.addListById(new HeroNode(1, "11", "及时雨"));
        linkedList1.addListById(new HeroNode(2, "22", "智多星"));
        linkedList1.addListById(new HeroNode(3, "33", "豹子头"));
        linkedList1.addListById(new HeroNode(5, "鲁55", "花和尚"));
        linkedList1.addListById(new HeroNode(8, "88", "白老虎"));
        singleLinkedList linkedList2 = new singleLinkedList();
        linkedList2.addListById(new HeroNode(2, "22", "智多星"));
        linkedList2.addListById(new HeroNode(3, "33", "豹子头"));
        linkedList2.addListById(new HeroNode(4, "44", "行者"));
        linkedList2.addListById(new HeroNode(5, "鲁55", "花和尚"));
        linkedList2.addListById(new HeroNode(6, "卢66", "玉麒麟"));
        linkedList2.addListById(new HeroNode(7, "77", "入云龙"));
        System.out.println("----------linkedList1---------------");
        linkedList1.showAll();
        System.out.println("----------linkedList2---------------");
        linkedList2.showAll();
        System.out.println("----------combineList2---------------");
        HeroNode newHead = combineList(linkedList1, linkedList2);
        singleLinkedList newLinkedList = new singleLinkedList();
        newLinkedList.showAll(newHead);
    }

    //链表合并的方法：
    public static HeroNode combineList(singleLinkedList list1, singleLinkedList list2) {
        HeroNode head1 = list1.getHeadNode();
        HeroNode head2 = list2.getHeadNode();
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode newTemp=newHead;
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        while (temp1!=null&&temp2!=null) {
            if (temp1.id < temp2.id) {
                newTemp.next = temp1;
                temp1 = temp1.next;
                newTemp=newTemp.next;
            } else if (temp1.id== temp2.id) {
                newTemp.next = temp1;
                temp1 = temp1.next;
                temp2=temp2.next;
                newTemp=newTemp.next;
            } else {
                newTemp.next = temp2;
                temp2 = temp2.next;
                newTemp=newTemp.next;
            }
        }
        if (temp1==null) {
            newTemp.next = temp2;
        }else if (temp2 == null) {
            newTemp.next = temp1;
        }
        return newHead;
        //        双层的while循环失败了，逻辑太复杂，把自己搞迷糊了
        ///*        HeroNode head1 = list1.getHeadNode();
//        HeroNode head2 = list2.getHeadNode();
//        HeroNode newHead =new HeroNode(0,"","");
//        HeroNode temp1 = head1.next;
//        HeroNode temp2 = head2.next;
//        HeroNode next1 = null;
//        HeroNode next2 = null;
//        while(true){
//            next1 = temp1.next;
//            while(true){
//                if (temp2.id>temp1.next.id){
//                    break;
//                }else if (temp2.next==null){
//                    break;
//                }else{
//                    temp2.next=temp1.next;
//                    temp1.next=temp2;
//                }
//
//            }
//            if (temp1.next==null){
//                break;
//            }
//            temp1 =temp1.next;
//        }
//        newHead.next = temp1;
//        return newHead;*/
    }
}
