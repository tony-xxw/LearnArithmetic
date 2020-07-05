package algorithm.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达是求值
 * <p>
 * 3+4*8-6 = 29
 * <p>
 * 1.首先遍历表达式
 * 2.如果为数字直接压入数栈
 * 1) 需要判断是否为个位数以上
 * 3.如果扫描到是符号
 * 1)符号栈为空,直接入栈
 * 2)符号栈有符号,判断优先级
 * -1 如果当前优先级大于符号栈顶优先级,直接入栈
 * -2 如果当前优先级小于或等于符号栈顶符号优先级,从数栈pop两个数,从符号栈pop一个符号,进行运算,得到结果入数栈,再将当前符号入符号栈
 * 4.当表达式扫描完,按顺序从数栈和符号栈pop相应的符号与数,计算的结果为表达式的计算结果
 */
public class CalculatorStack {


    public static void main(String[] args) {
        String expression = " 2+100*8/4-10";

        System.out.println(scanExpression(expression));
        List<String> expressions = scanExpression(expression);

        Stack<String> symbolStack = new Stack<String>();
        Stack<String> valueStack = new Stack<String>();

        int result;
        String mul = "";


        for (int i = 0; i < expressions.size(); i++) {
            String item = expressions.get(i);
            //如果是数字 直接入栈
            if (item.charAt(0) > 47 && item.charAt(0) < 58) {
                //判断是否大于个位数
                if (i == expressions.size() - 1) {
                    //为最后一个 直接压入栈
                    if (mul.isEmpty()) {
                        valueStack.push(item);
                    } else {
                        mul += item;
                        valueStack.push(mul);
                        mul = "";
                    }

                } else if (obtainPriority(expressions.get(i + 1)) != 0) {
                    //下一位不为数字直接压入
                    if (mul.isEmpty()) {
                        valueStack.push(item);
                    } else {
                        mul += item;
                        valueStack.push(mul);
                        mul = "";
                    }

                } else {
                    //下一位为数字,叠加
                    mul += item;
                }

            } else if (item.charAt(0) < 48) {
                //符号入栈
                //如果栈空
                if (symbolStack.size() == 0) {
                    symbolStack.push(item);
                } else {
                    //栈不空且 优先级小于或等于当前符号
                    if (obtainPriority(item) <= obtainPriority(symbolStack.peek())) {
                        //数字栈pop2个数,从符号栈pop一个数,计算结果压入数字栈,当前符号入栈
                        String num1 = valueStack.pop();
                        String num2 = valueStack.pop();
                        String sysbol = symbolStack.pop();
                        result = cal(Integer.valueOf(num1), Integer.valueOf(num2), sysbol);
                        //将结果压入数栈
                        valueStack.push(String.valueOf(result));
                        symbolStack.push(item);
                    } else if (obtainPriority(item) > obtainPriority(symbolStack.peek())) {
                        //直接压入栈
                        symbolStack.push(item);
                    }
                }
            }
        }


        //按顺序弹出计算
        while (symbolStack.size() != 0) {
            String num1 = valueStack.pop();
            String num2 = valueStack.pop();
            String sysbol = symbolStack.pop();
            result = cal(Integer.valueOf(num1), Integer.valueOf(num2), sysbol);
            valueStack.push(String.valueOf(result));
        }

        if (valueStack.peek() != null) {
            System.out.println("结果为: " + valueStack.pop());
        }

    }

    public static List<String> scanExpression(String expression) {
        expression = expression.trim();
        List<String> expressions = new ArrayList<>();
        //扫描表达式
        for (int i = 0; i < expression.length(); i++) {
            expressions.add(String.valueOf(expression.charAt(i)));
        }

        return expressions;
    }

    public static int obtainPriority(String symbol) {
        int ADD = 1;
        int SUB = 1;
        int MUL = 2;
        int DIV = 2;
        int result = 0;
        switch (symbol) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("为数字");
                break;
        }
        return result;
    }

    public static int cal(int num1, int num2, String symbol) {
        int result = 0;
        switch (symbol) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                System.out.println("没有符合的符号");
                break;
        }
        return result;
    }
}
