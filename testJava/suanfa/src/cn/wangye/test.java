package cn.wangye;

public class test {
    public static void main(String[] args) {
       Person p1=new Person("老王",30);
       Dog dog=new Dog(2,"灰");
       p1.keepPet(dog,"骨头");

       Person p2=new Person("老李",35);
       Cat cat =new Cat(3,"白");
       p2.keepPet(cat,"小鱼干");
    }
}
