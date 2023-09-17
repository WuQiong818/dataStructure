package cn.wangye.stack;

import java.util.Arrays;

/*
 * 难点：
 * 思路分析比较难一点
 * 特别是运算符的权重和计算的方法的处理;
 *
 * 问题：多字符转换接受没有整好
 * */
public class calculator {
    public static void main(String[] args) {
        String expression = "1*32*4+1-6*3";
        Stack numStack = new Stack(10);
        Stack operStack = new Stack(10);
        int index = 0;
        char ch = ' ';
        String newNum = "";
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res;
        boolean flag = false;
        while (index < expression.length()) {
            ch = expression.substring(index, index + 1).charAt(0);
            //如果字符是操作符
            if (operStack.isOperation(ch)) {
                if (!operStack.isEmpty()) {
                    //如果新添加的运算符的权重小于、等于
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num2, num1, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
//                numStack.push((ch - 48));
                //进行多位数的处理;我们需要在ch的基础上，在往后看一看。
                // 如果下一个数字仍然是数字，则进行拼接，如果下一个数不是字符，就直接添加;
                //下一个不是运算符
                newNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(newNum));
                } else {
                    if (operStack.isOperation(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(newNum));
                        newNum = "";
                    }
                }
            }
            index++;
        }
        while (!operStack.isEmpty()) {
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int result = numStack.pop();
        System.out.println("计算结果为" + result);
    }
}


class Stack {
    private int[] array;
    private int maxSize;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public void push(int num) {
        if (isFull()) {
            System.out.println("栈已满，请进行出栈操作后继续");
            return;
        }
        top++;
        array[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈已空，请添加后重试吧!");
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = array[top];
        top--;
        return value;
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("栈已空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("查询的top值为" + i + "值为" + array[i]);
        }
    }


    public int peek() {
        if (isEmpty()) {
            System.out.println("栈为空，请添加后在进行操作吧!");
        }
        return array[top];
    }

    public boolean isBracket(char val) {
        return val == '(' || val == ')';
    }

    public boolean isOperation(char val) {
        return (val == '+' || val == '-' || val == '*' || val == '%' || val == '(' || val == ')');
    }

    public int priority(int operation) {
        if (operation == '+' || operation == '-') {
            return 0;
        } else if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '(' || operation == ')') {
            return 2;
        } else {
            return -1;
        }
    }

    public int cal(int a, int b, int operation) {
        int res = 0;
        switch (operation) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }
}

