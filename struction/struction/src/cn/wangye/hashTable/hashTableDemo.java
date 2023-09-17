package cn.wangye.hashTable;
/*我需要先准备好三个类：
1.hashTab类 数组,里面存放链表;[确定id在哪一个链表]
2.链表类，EmpLinkedList head 一些数组的操作方法，调用者;[确定id在链表的那一个位置]
3.Emp对象 int id,String name等员工信息增、删、改、查具体的实现方法;[存储者和被操控者]
*/

public class hashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Emp emp = new Emp(1, "wang");
        Emp emp1 = new Emp(8, "ye");
        Emp emp2 = new Emp(15, "liu");
        Emp emp3 = new Emp(22, "wan");
        Emp emp4 = new Emp(29, "chang");

        hashTab.add(emp);
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);

        hashTab.list();
        Emp findEmp = hashTab.findEmpById(29);
        if (findEmp != null) {
            System.out.println(findEmp.toString());
        }
    }
}

class HashTab {
    private int size;
    EmpLinkedList[] empLinkedLists;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
    }

    public int hashFun(int id) {
        return id % size;
    }

    public void add(Emp emp) {
        int id = emp.id;
        int index = hashFun(id);
        if (empLinkedLists[index] == null) {
            empLinkedLists[index] = new EmpLinkedList();
        }
        empLinkedLists[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            if (empLinkedLists[i] != null) {
                empLinkedLists[i].list(i);
            }
        }
    }

    public Emp findEmpById(int id) {
        int index = hashFun(id);
        if (empLinkedLists[index] != null) {
            return empLinkedLists[index].findEmpById(id);
        } else {
            System.out.println("当前hash中没有该员工的信息");
            return null;
        }
    }

}

class EmpLinkedList {
    Emp head;

    public void add(Emp emp) {
        //判断头节点有没有数据，如果没有数据的话，直接添加到头部，如果有数据的话，那么我就直接在链表的最后进行添加。
        if (head == null) {
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
        return;
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第" + i + "个链表是空的，没有任何数据");
            return;
        }
        System.out.println("第" + i + "个链表中的信息有:");

        Emp curEmp = head;
        while (true) {
            System.out.println("id" + curEmp.id + ";name" + curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表是空的");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                return curEmp;
            }
            if (curEmp.next == null) {
                return null;
            }
            curEmp = curEmp.next;
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


































