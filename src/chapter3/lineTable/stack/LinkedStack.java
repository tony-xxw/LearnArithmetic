package chapter3.lineTable.stack;

import chapter3.lineTable.linked.Node;

import java.util.Stack;

/**
 * 链栈
 */
public class LinkedStack {
    Node top;
    int size;

    public void init() {
        top = null;
        size = 0;
    }


    private void push(String content) {
        Node newNode = new Node(content);
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
        size++;
        System.out.println("进栈:" + newNode.content);
    }

    private void pop() {
        String item = "";
        if (!isEmpty()) {
            item = top.content;
            top = top.next;
            size--;
        }
        System.out.println("出栈: " + item);
    }

    private void peek() {
        String item = "";
        if (!isEmpty()) {
            item = top.content;
        }
        System.out.println("栈顶内容为: " + item);
    }

    private void size() {
        System.out.println("链栈为: " + size);
    }

    private boolean isEmpty() {
        if (top == null && size == 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        stack.size();

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.size();
        stack.peek();

    }
}
