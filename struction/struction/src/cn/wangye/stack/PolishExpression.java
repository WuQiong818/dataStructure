package cn.wangye.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishExpression {
    public static void main(String[] args) {
//        String expression = "3 4 + 5 * 6 -";
        String expression = "30 4 + 5 * 6 -";

        //这里是直接对输入的后缀表达式进行运算，我们利用list集合，对其实现分割。
        int result = calculate(expression);
        System.out.println(result);
    }
    public static int calculate(String expression) {
        String[] str = expression.split(" ");
        Stack<String> stack = new Stack<>();
        for (String ele : str) {
            //这里并不是直接进行入栈操作，而是如果是数组就入栈，不是数字，就pop出来两个数字，进行运算，对运算的结果进行入栈
            if (ele.matches("\\d+")) {
                stack.push(ele);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
//                String oper = stack.pop();这里是ele是运算符，在栈中取出来两个数即可，注意，现在栈中不再进行符号的存储了；
                int res = 0;
                if (ele.equals("+")) {
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num1 - num2;
                } else if (ele.equals("*")) {
                    res = num1 * num2;
                } else if (ele.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("违规操作，非法操作符");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}