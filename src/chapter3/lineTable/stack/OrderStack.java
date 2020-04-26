package chapter3.lineTable.stack;

import java.util.ArrayList;

/**
 * 顺序栈
 */
public class OrderStack {
    private ArrayList<String> orderStack = new ArrayList<String>();
    //代表空栈
    private int top = 0;
    private int MAX_SIZE = 5;


    /**
     * 进栈
     */
    private void push(String element) {
        if (orderStack.size() == MAX_SIZE) {
            return;
        }
        top++;
        orderStack.add(element);
    }

    /**
     * 出栈
     */
    private void pop() {
        if (top == 0) {
            return;
        }
        top--;
        orderStack.remove(orderStack.size() - 1);
    }


    private void log() {
        String content = "";
        for (int i = 0; i < orderStack.size(); i++) {
            if (i==orderStack.size()-1){
                content += orderStack.get(i) ;
            }else {
                content += orderStack.get(i) + "=>";
            }
        }
        System.out.println(content);
    }


    public static void main(String[] args) {
        OrderStack orderStack = new OrderStack();
        orderStack.push("a");
        orderStack.push("b");
        orderStack.push("c");
        orderStack.push("d");

        orderStack.log();

        orderStack.pop();
        orderStack.pop();
        orderStack.log();
    }
}
