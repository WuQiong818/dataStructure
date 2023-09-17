package cn.wangye.linkedList.doubleLinkedList.singleLinkedList;

class singleLinkedList {
    private HeroNode headNode = new HeroNode(0, "", "");

    public HeroNode getHeadNode() {
        return headNode;
    }

    public void addList(HeroNode heroNode) {
        //模拟指针，使用一个临时变量
        HeroNode temp = headNode;
        //不考虑位置，按顺序加入,下一个为空，就加入,要注意下标的移动，next为空后，加入一个对象，并且是next后移一位；
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序进行数据的添加；
     *
     * @param heroNode
     */
    public void addListById(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > heroNode.id) {
                break;
            } else if (temp.next.id == heroNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("好汉的" + heroNode.id + "相同了");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void showAll() {
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void showAll(HeroNode head) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void deleteById(int id) {
        //通过id名进行删除某一个节点
        HeroNode temp = headNode;
        while (true) {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            if (temp.next == null) {
                System.out.println("编号" + id + "已经被删除！");
                break;
            }
        }
    }

    public void updateById(int id, String newName, String newNickName) {
        HeroNode temp = headNode;
        while (true) {
            if (temp.next.id == id) {
                temp.next.name = newName;
                temp.next.nickName = newNickName;
                break;
            }
            temp = temp.next;
            if (temp.next == null) {
                System.out.println("编号错误,未查询到" + id + ",请重新输入！");
                break;
            }
        }
    }

    /**
     * 获取链表的有效长度，不含头部节点;
     *
     * @param headNode 头部节点 getHeadNode()方法获取
     * @return 返回int长度
     */
    public int getLength(HeroNode headNode) {
        if (headNode.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = headNode;
        while (true) {
            if (temp.next != null) {
                length++;
                temp = temp.next;
            } else {
                break;
            }
        }
        return length;
    }

    /**
     * 查找链表中倒数第index个节点；
     *
     * @param headNode 我们需要根据头部的节点去进行查找，因为头部节点是我们的开始；
     * @param index    想要获取的倒数第几个节点
     * @return 返回查找的节点
     * 单向链表，倒数转成整数；
     * 1.先遍历所有，获取链表的长度
     * 2.长度-index,等到链表的正数排行
     * 再次遍历数据，获取该节点；
     */
    public HeroNode searchBackwardNode(HeroNode headNode, int index) {
        int length = getLength(headNode);
        HeroNode temp = headNode;
        int size = length - index + 1;
        int count = 0;
        while (true) {
            if (temp.next != null) {
                temp = temp.next;
                count++;
                if (size == count) {
                    break;
                }
            } else {
                System.out.println("输入有误，请重新输入");
                return null;
            }

        }
        return temp;

    }

    /**
     * 链表反转，但为空或者为一个的时候，直接返回
     * 传入的是头部变量，我自己定义一个尾部的变量
     * 中间进行临时值的存储，
     *
     * @param headNode
     */
    public void reversalList(HeroNode headNode) {
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        HeroNode foot = new HeroNode(0, " ", "");//创建反转链表的头部
        HeroNode temp = null;//创建一个临时变量帮助我们存储
        HeroNode next = headNode.next;//创建next变量帮助我们遍历
        while (next != null) {
            temp = next.next;//利用临时变量temp,对next.next进行存储
//            这样书写将导致一个循环体的出现，foot的下一个节点是next,next的下一个节点还是foot的下一个节点，即next本身；
//            foot.next=next;
//            next.next=foot.next;
            next.next = foot.next;
            foot.next = next;


            next = temp;
        }
        headNode.next = foot.next;


    }
/*//    public void reversalList(HeroNode head) {
//        if (headNode.next==null||headNode.next.next==null){
//            return ;
//        }
//        HeroNode cur = head.next;//cur是一个临时的变量，帮助我们进行链表的遍历,直接表示第一个节点
//        HeroNode next = null;//next是一个辅助变量，帮助我们存储cur变量的下一个节点
//        HeroNode reverseHead = new HeroNode(0 , "","");//反转后的链表头
//
//        while(cur!=null){
//            next=cur.next;//用next保存cur的下一个节点
//            cur.next=reverseHead.next;//这个没看懂是什么意思,这一步是在为下一步做准备，提前会节点进行链接
//            reverseHead.next=cur;
//            cur=next;//实现cur的不断变化
//        }
//        head.next=reverseHead.next;
//    }*/


}
