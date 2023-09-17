package cn.wangye.linkedList.doubleLinkedList.singleLinkedList;

public class Test {
    static ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));

    public static void main(String[] args) {
        ListNode head = DeleteById(2);
        showAll(head);
        System.out.println(head.next);
    }

    public static ListNode DeleteById(int val) {
        ListNode head = new ListNode(0, null);
        head.next = list1;
        ListNode temp = head;
        while(temp!=null){


            temp=temp.next;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println("抱歉没有该值");
                break;
            }
            if (temp.next.val == val) {
                break;
            }
            temp=temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void showAll(ListNode head) {
        ListNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
