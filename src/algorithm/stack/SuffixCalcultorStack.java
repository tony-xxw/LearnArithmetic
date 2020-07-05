package algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式(逆波兰)
 * 例如(3+4)x5-6  = 29 后缀表达式为 3 4 + 5 x 6-
 * 1.首先遍历表达式
 * 2.定义一个数栈,用来压入数
 * 3.遇到符号就弹出两个栈计算再压入
 */
public class SuffixCalcultorStack {
    public static void main(String[] args) {
        String expression = "34+5*6-";
        System.out.println("后缀表达式遍历: " + scanExpression(expression));

        List<String> expressions = scanExpression(expression);
        System.out.println(caculationResult(expressions));

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

    public static String caculationResult(List<String> expressions) {
        //定义数栈
        Stack<String> valueStack = new Stack<>();
        for (String item : expressions) {
            if (item.charAt(0) > 48 && item.charAt(0) < 58) {
                //数字压入
                valueStack.push(item);
            } else {
                //符号弹出计算
                if (valueStack.size() != 0) {
                    String num1 = valueStack.pop();
                    String num2 = valueStack.pop();
                    String result = String.valueOf(CalculatorStack.cal(Integer.valueOf(num1), Integer.valueOf(num2), item));
                    //计算结果压入数栈
                    valueStack.push(result);
                }
            }
        }

        return valueStack.pop();
    }


}
