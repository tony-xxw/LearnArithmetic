package algorithm.stack;

public class ArrayStack {

    private int mMaxSize;
    private int top = -1;
    private int[] stack;


    public ArrayStack(int mMaxSize) {
        this.mMaxSize = mMaxSize;
        stack = new int[mMaxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == mMaxSize - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }

        top++;
        stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空,无无数据返回");
            return -1;
        }

        int value = stack[top];
        top--;
        return value;
    }

    public void listStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;

        }
        for (int i =top; i > -1; i--) {
            System.out.printf("stack[%d] = %d", i, stack[i]);
            System.out.println();
        }
    }


}
