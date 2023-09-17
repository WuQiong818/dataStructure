package cn.wangye.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class transform {
    public static void main(String[] args) {
//        String nifixExpression = "(3+4*2)*5-6";
//        String nifixExpression = "(8*4+5*3+1)*3-100";
        String nifixExpression = "1+((2+3)*4)-5";//输入的时候，注意一下中英文的括号，（(大小不一样；
        List<String> list = transFormList(nifixExpression);
        System.out.println(transFromExpression(list));//转化为后缀表达式
        int res = calculate(transFromExpression(list));
        System.out.println(res);
    }

    public static List<String> transFormList(String nifixExpression) {
        List<String> list = new ArrayList<>();
        int index = 0;
        String str = "";
        String keepStr = "";
        while (true) {
            /*
             * 将字符串转化为list的关键在于条件判断
             * 1.如果是符号直接进行入栈的操作；
             * 2.如果是数字的话，
             * 判断下一个是否是符号，是符号才进行提交，不是符号就一直进行累加；
             * 如果是最后一个，也进行提交
             * */
            str = nifixExpression.substring(index, index + 1);
            if (str.equals("（")||str.equals("）")){
                throw new RuntimeException("请输入英文括号");
            }
            if (index == nifixExpression.length() - 1) {//进行判断，如果已经到了最后一个，就直接进行提交，并且退出循环。
                keepStr += str;
                list.add(keepStr);
                break;
            }
            if (isOperation(str)) {//如果是运算符的话，直接让其入栈
                list.add(str);
            } else {
                keepStr += str;//上面有过一次str的赋值，此时在进行赋值，会造成字符串的重复
                //直到下一个是运算符才进行提交
                if (isOperation(nifixExpression.substring(index + 1, index + 2))) {
                    list.add(keepStr);
                    keepStr = "";
                }
            }
            index++;
        }
        return list;
    }

    /**
     * 这个地方是中缀表达式转换为逆波兰表达式，并不是运算，运算不需要这么麻烦，之前发后缀表达式的运算理解错了
     * 难在在符号的判断上面，优先级和括号
     * 1.如果是数，直接进行入栈的操作
     * 2.如果是符号
     * （1）如何符号栈为空或者符号前面是（，直接进行入栈
     * (2) 不空
     * 1）前面已经有符号了，优先级判断，如果优先级高于前面的，直接入栈，
     * 如果优先级低于前面的，pop出前面的符号和二个数，进行运算，运算结果入栈，再进行符号的入栈
     * 2）如果符号是），那么，我们依次pop出符号，之间将（取出，并且用符号同数进行运算；
     *
     * @param ”expression中缀表达式“
     * @return 计算结果，过程栈中的最后一个数，直接pop出即可
     */
    public static Stack<String> transFromExpression(List<String> expression) {
        int index = 0;
        Stack<String> operationStack = new Stack<>();//符号栈
        Stack<String> processStack = new Stack<>();//过程栈
        Stack<String> postfixExpression = new Stack<>();//逆序栈
        while (index < expression.size()) {
            String exp = expression.get(index);
            if (isOperation(exp)) {
                if (operationStack.empty() || operationStack.peek().equals("(")) {
                    operationStack.push(exp);
                } else {
                    if (priority(exp) > priority(operationStack.peek())) {
                        if (exp.equals(")")) {
                            while (!(operationStack.peek().equals("("))) {
                                processStack.push(operationStack.pop());
                            }
                            if (operationStack.peek().equals("(")) {
                                operationStack.pop();
                            }
                        } else {
                            operationStack.push(exp);
                        }
                    } else if (priority(exp) <= priority(operationStack.peek())) {
                        String oper = operationStack.pop();
                        processStack.push(oper);
                        operationStack.push(exp);
                    }
                }
            } else {
                processStack.push(exp);
            }
            index++;
        }
        while (!operationStack.empty()) {
            processStack.push(operationStack.pop());
        }

        while (!processStack.empty()) {
            postfixExpression.push(processStack.pop());
        }
        return postfixExpression;
    }

    public static int calculate(Stack<String> postfixExpression) {
        Stack<Integer> result = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res;
        while (!postfixExpression.empty()) {
            String a = postfixExpression.peek();
            if (!isOperation(a)) {
                result.push(Integer.valueOf(postfixExpression.pop()));
            } else {
                num2 = result.pop();
                num1 = result.pop();
                a=postfixExpression.pop();
                res = cal(num1,num2,a);
                result.push(res);
            }
        }
        return result.pop();
    }

    public static int priority(String operation) {
        if (operation.equals("+") || operation.equals("-")) {
            return 0;
        } else if (operation.equals("*") || operation.equals("/")) {
            return 1;
        } else if (operation.equals("(") || operation.equals(")")) {
            return 2;
        } else {
            return -1;
        }
    }

    public static int cal(int a, int b, String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
        }
        return res;
    }

    public static boolean isOperation(String val) {
        return val.equals("(") || val.equals(")") || val.equals("+")
                || val.equals("-") || val.equals("*") || val.equals("/");
    }
}
