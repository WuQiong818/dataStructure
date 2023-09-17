package cn.wangye.linkedList.doubleLinkedList;

public class doubleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "武松", "行者");
        HeroNode heroNode5 = new HeroNode(5,"鲁智深","花和尚");
        HeroNode heroNode6 = new HeroNode(6,"卢俊义","玉麒麟");
        doubleLinkedList linkedList = new doubleLinkedList();
////        linkedList.addListById(heroNode3);
//        linkedList.addListById(heroNode1);
//        linkedList.addListById(heroNode4);
//        linkedList.addStartList(heroNode5);
//        linkedList.addEndList(heroNode2);
        linkedList.addListById(heroNode6);
        linkedList.addListById(heroNode5);
        linkedList.addListById(heroNode3);
        linkedList.addListById(heroNode4);
        linkedList.addListById(heroNode2);
//        linkedList.addListById(heroNode2);
        linkedList.updateById(2,"有用","智多星");
        linkedList.deleteById(2);
        linkedList.showAll();
    }
}

class doubleLinkedList {
    private HeroNode headNode = new HeroNode(0, "", "");

    public HeroNode getHeadNode() {
        return headNode;
    }

    //增 默认在链表后添加和按序号添加
    public void addEndList(HeroNode heroNode) {
        //模拟指针，使用一个临时变量
        HeroNode temp = headNode;
        //不考虑位置，按顺序加入,下一个为空，就加入,要注意下标的移动，next为空后，加入一个对象，并且是next后移一位；
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void addStartList(HeroNode heroNode) {
        if (headNode.next==null){
            headNode.next=heroNode;
        }else{
            headNode.next.pre = heroNode;
            heroNode.pre=headNode;
            heroNode.next = headNode.next;
            headNode.next=heroNode;
        }

    }

    public void addListById(HeroNode heroNode) {
        boolean flag = false;
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.id > heroNode.id) {
                break;
            } else if (temp.next.id == heroNode.id) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (flag) {
            System.out.println("已有相同的编号" + heroNode.id);
        } else {
            if (temp.next != null) {
                temp.next.pre = heroNode;
                heroNode.pre = temp;
                heroNode.next = temp.next;
                temp.next = heroNode;
            } else {
                temp.next = heroNode;
                heroNode.pre = temp;
            }
        }
    }

    //删 按序号进行删除
    public void deleteById(int id) {
        //通过id名进行删除某一个节点
        HeroNode temp = headNode;
        while (true) {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                temp.next.pre = temp;
                break;
            }
            temp = temp.next;
            if (temp.next == null) {
                System.out.println("编号" + id + "已经被删除！");
                break;
            }
        }
    }

    //改 按序号进行修改，但还是需要传过来一个对象
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

    //查 直接查询所有
    public void showAll() {
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode() {
    }

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}