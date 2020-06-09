package algorithm.quque;


import java.util.Scanner;

public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(peek): 查看队列头的数据");
            System.out.println("r(rest): 清空队列");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQuque();
                    break;
                case 'a':
                    System.out.println("输一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int data = queue.obtainQueue();
                        System.out.printf("取出的数据是%d\n", data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int data = queue.peek();
                        System.out.printf("队列头的数据是%d\n", data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'r':
                    queue.reset();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序已推出");


    }


    static class ArrayQueue {
        private int mMaxSize;
        private int mFront;
        private int mRear;
        private int[] queue;


        public ArrayQueue(int maxSize) {
            mMaxSize = maxSize;
            mFront = -1;
            mRear = -1;
            queue = new int[maxSize];
        }

        //队列是否满
        public boolean isFull() {
            return mRear + 1 == mMaxSize;
        }

        //队列是否为空
        public boolean isEmpty() {
            return mFront == mRear;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列已满");
                return;
            }
            queue[++mRear] = n;
        }

        public int obtainQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空,请先添加数据");
            }
            return queue[++mFront];
        }

        public void showQuque() {
            if (isEmpty()) {
                System.out.println("队列为空,请先添加数据");
                return;
            }
            for (int i = 0; i < queue.length; i++) {
                System.out.printf("queue[%d] = %d\n", i, queue[i]);
            }
        }

        //获取头部
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空,请先添加数据");
            }
            return queue[++mFront];
        }

        public void reset() {
            mFront = -1;
            mRear = -1;
        }
    }
}
