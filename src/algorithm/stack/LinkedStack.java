package algorithm.stack;

import algorithm.linked.Node;
import algorithm.linked.SingleLinked;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;

import java.util.concurrent.ExecutionException;

public class LinkedStack {
    private int mMaxSize;
    private int top = -1;
    private SingleLinked singleLinked;

    public LinkedStack(int mMaxSize) {
        this.mMaxSize = mMaxSize;
        singleLinked = new SingleLinked();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == mMaxSize - 1;
    }

    public void push(Node data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }

        Node temp = singleLinked.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        top++;
        temp.next = data;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        Node temp = singleLinked.head;
        Node head = new Node(0);
        head.next = temp.next;
        singleLinked.head = head.next;
        top--;
        return temp;
    }

    public void listStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;

        }

        Node temp = reversal();

        while (temp.next != null) {
            System.out.printf("stack = %d", temp.no);
            System.out.println();
            temp = temp.next;
        }
        System.out.printf("stack = %d", temp.no);
        System.out.println();
    }

    public Node reversal() {
        if (singleLinked == null) {
            throw new RuntimeException("栈空");
        }
        Node newNode = null;
        Node oldNode;
        Node temp = singleLinked.head.next;


        while (temp.next != null) {
            oldNode = temp.next;
            temp.next = newNode;
            newNode = temp;
            temp = oldNode;
        }

        temp.next = newNode;
        singleLinked.head = temp;
        return temp;

    }
}
