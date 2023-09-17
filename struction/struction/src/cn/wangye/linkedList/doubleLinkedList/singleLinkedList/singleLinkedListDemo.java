package cn.wangye.linkedList.doubleLinkedList.singleLinkedList;

public class singleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "武松", "行者");
        singleLinkedList linkedList = new singleLinkedList();
        linkedList.addListById(heroNode3);
        linkedList.addListById(heroNode1);
        linkedList.addListById(heroNode4);
        linkedList.addListById(heroNode2);
        linkedList.showAll();
        System.out.println(linkedList.getLength(linkedList.getHeadNode()));
        System.out.println(linkedList.searchBackwardNode(linkedList.getHeadNode(), 1));
        System.out.println(linkedList.searchBackwardNode(linkedList.getHeadNode(), 2));
        System.out.println(linkedList.searchBackwardNode(linkedList.getHeadNode(), 3));
        System.out.println(linkedList.searchBackwardNode(linkedList.getHeadNode(), 4));
        System.out.println("进行链表的反转");
        linkedList.reversalList(linkedList.getHeadNode());
        linkedList.showAll();
    }
}


