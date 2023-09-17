package dierdanyuan;

public class duotai {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

    }

}

class Animal {
    int age;
    String color;

    private void eat(String food) {
        System.out.print("正在吃" + food);
    }
}

class Dog extends Animal {
    private void lookHome() {
        System.out.print("狗正在看家");
    }
}

class Cat extends Animal {
    private void catchMouse() {
        System.out.print("猫正在抓老鼠");
    }
}

class Person {
    String name;
    int age;

    void keepPet(Object obj, String food) {
        System.out.print("喂养宠物" + obj + "正在埋着头吃" + food);
    }
}
class siYangYuan extends Person{

}
