package algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static algorithm.stack.SuffixCalcultorStack.caculationResult;

/**
 * 中缀转后缀
 * 中缀表达式 4*10+(20-8) = 52
 * 后缀表达式
 * 1.初始化2个栈, 运算符栈(S1)和存储中间结果栈(S2)
 * 2.从左至右遍历
 * 3.遇到操作数压入S2
 * 4.遇到运算符时,比较其与S1栈顶运算符的优先级
 * 1)如果S1为空,或者栈顶运算符为左括号(，直接运算符入栈 S1
 * 2)否则,当前运算符优先级高于栈顶运算符,将运算符压入
 * 3)否则,将S1栈顶运算符弹出压入到S2中,再回到4-1与S1中心的栈顶运算符比较
 * 5.遇到括号时
 * 1)如果"("直接压入S1
 * 2)如果")" 则依次弹出S1栈顶运算符,并压入S2,直到遇到左括号为止,此时将这一对括号丢弃重复2-5,直到表达式结束
 * 将S1中剩余的表达式压入S2
 * 将一次弹出的S2中的元素弹出, 逆向后为转换成功
 */
public class ExpressionConver {
    public static void main(String[] args) {
        String expression = "4*10+50-20";
        System.out.println(obtainExpressions(expression));

        List<String> expressions = obtainExpressions(expression);
        List<String> result = new ArrayList<>();

        Stack<String> symbol = new Stack<>();

        String mul = "";
        for (int i = 0; i < expressions.size(); i++) {
            String item = expressions.get(i);

            //如果是数字直接压入加入结果
            if (item.charAt(0) > 47 && item.charAt(0) < 58) {
                if (i == expressions.size() - 1) {
                    if (result.isEmpty()) {
                        result.add(item);
                    } else {
                        mul += item;
                        result.add(mul);
                        mul = "";
                    }
                } else if (expressions.get(i + 1).charAt(0) > 47 && expressions.get(i + 1).charAt(0) < 58) {
                    mul += item;
                } else {
                    if (result.isEmpty()) {
                        result.add(item);
                    } else {
                        mul += item;
                        result.add(mul);
                        mul = "";
                    }
                }

            } else if (item.charAt(0) == 40) {
                //40 ASCII表为( 直接压入符号栈
                symbol.push(item);
            } else if (item.charAt(0) == 41) {
                //41 ASCII表为)
                //当为) 一直弹出符号栈直到为(为止,并弹出
                while (symbol.peek().charAt(0) != 40) {
                    result.add(symbol.pop());
                }
                //弹出
                symbol.pop();
            } else if (item.charAt(0) < 48) {
                //当为运算符
                if (symbol.isEmpty() || symbol.peek().charAt(0) == 40) {
                    symbol.push(item);
                } else if (CalculatorStack.obtainPriority(item) > CalculatorStack.obtainPriority(symbol.peek())) {
                    //当前符号优先级高于栈顶压入
                    symbol.push(item);
                } else {
                    //当前优先级低于 或等于符号栈顶  弹出符号栈栈顶元素 压入结果中,并将当前符号压入符号栈
                    result.add(symbol.pop());
                    symbol.push(item);
                }
            }

        }


        while (symbol.size() != 0) {
            result.add(symbol.pop());
        }

        System.out.println("后缀表达式为: " + result);

        System.out.println("后缀表达式求值为: " + caculationResult(result));

    }

    public static List<String> obtainExpressions(String expression) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < expression.length(); i++) {
            list.add(String.valueOf(expression.charAt(i)));
        }
        return list;
    }
}
