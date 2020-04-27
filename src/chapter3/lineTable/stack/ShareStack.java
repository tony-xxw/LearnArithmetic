package chapter3.lineTable.stack;

import java.util.ArrayList;

/**
 * 共享栈
 */
public class ShareStack {

    private final int MaxSize = 10;
    String[] shareTask = new String[MaxSize];
    private int top1 = -1;
    private int top2 = MaxSize;

    private void push(String element, int stackNumber) {
        if (top1 + 1 == top2) {
            System.out.println("栈满了");
            return;
        }
        if (stackNumber == 1) {
            top1++;
            shareTask[top1] = element;
        } else if (stackNumber == 2) {
            top2--;
            shareTask[top2] = element;
        }

    }

    private void pop(int stackNumber) {
        if (top1 == -1 || top2 == MaxSize) {
            System.out.println("栈空了");
            return;
        }
        if (stackNumber == 1) {
            shareTask[top1] = "";
            top1--;
        } else if (stackNumber == 2) {
            shareTask[top2] = "";
            top2++;
        }
    }

    private String peek(int stackNumber) {
        if (stackNumber == 1) {
            if (top1 == -1) {
                System.out.println("空栈");
                return "";
            }
            return shareTask[top1];
        } else {
            if (top2 == MaxSize) {
                System.out.println("空栈");
                return "";
            }
            return shareTask[top2];
        }


    }

    public static void main(String[] args) {
        ShareStack shareStack = new ShareStack();
        shareStack.push("a", 1);
        shareStack.push("c", 2);
        System.out.println(shareStack.peek(1));
        System.out.println(shareStack.peek(2));
    }
}
