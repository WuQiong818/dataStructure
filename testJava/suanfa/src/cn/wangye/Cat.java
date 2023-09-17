package cn.wangye;

public class Cat extends Animal{

    public void catchMouse(){
        System.out.print("猫在抓老鼠");
    }

    public Cat(int age, String color) {
        super(age, color);
    }
    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁的"+getColor()+"颜色的猫眯着眼睛侧着头吃"+something);
    }
}
