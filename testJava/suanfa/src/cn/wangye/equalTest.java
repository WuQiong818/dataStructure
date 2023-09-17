package cn.wangye;

class A{
    int a=1;
}

public class equalTest {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 =new A();
        if (obj1.equals(obj2)){
            System.out.print(12231);
        }
        String obj3=new String("123");
        String obj4=new String("123");
        if (obj3.equals(obj4)){
            System.out.print("obj3.equals(obj4)");
        }
    }

}

