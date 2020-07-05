package algorithm.stack;

import algorithm.linked.Node;

public class StackDemo {

    public static void main(String[] args) {


//        testLinkedStack();
        testArrayStack();
    }


    public static void testArrayStack() {

        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.listStack();
        System.out.println();

        System.out.printf("出栈: %d", stack.pop());

        System.out.println();
        stack.listStack();
    }

    public static void testLinkedStack() {
        LinkedStack stack = new LinkedStack(5);
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.push(new Node(4));
        stack.push(new Node(5));

        stack.listStack();
        System.out.println();

//        System.out.printf("出栈: %d", stack.pop().no);
//        System.out.println();
//        System.out.printf("出栈: %d", stack.pop().no);
//        System.out.println();
//        System.out.printf("出栈: %d", stack.pop().no);
//        System.out.println();
//        System.out.printf("出栈: %d", stack.pop().no);
//        System.out.println();
//        System.out.printf("出栈: %d", stack.pop().no);

//        System.out.println();
        stack.listStack();
    }
}
