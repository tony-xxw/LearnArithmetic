package chapter3.lineTable.quque;

public class CycleQuque {

    int[] type = new int[5];
    private int front;
    private int rear;

    void init() {
        front = 0;
        rear = 0;
    }

    int obtainQuqueSize() {
        return (rear - front + type.length) % type.length;
    }

    void enQueue(int element) {
        if ((rear + 1) % type.length == front) {
            System.out.println("队列已满");
            return;
        }
        type[rear] = element;
        rear = (rear + 1) % type.length;

    }

    void deQueue() {
        if (front == rear) {
            return;
        }
        int element = type[front];
        front = (front + 1) % type.length;
        System.out.println("element: " + element);
    }


    public static void main(String[] args) {
        CycleQuque cycleQuque = new CycleQuque();
        cycleQuque.enQueue(1);
        cycleQuque.enQueue(2);
        cycleQuque.enQueue(3);
        cycleQuque.enQueue(4);
        cycleQuque.enQueue(4);
        cycleQuque.deQueue();
        cycleQuque.deQueue();
        System.out.println("size: "+cycleQuque.obtainQuqueSize());
    }
}
