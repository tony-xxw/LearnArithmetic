package algorithm.linked;

/**
 * 链表的约瑟夫问题
 * 有N个小孩,围绕成一个圈,从1依次开始报数,数到的M小孩出队。下位又是从1报数,数到M出列,依次类推到结束.求出队队列
 */
public class JosephLinkedList {

    Node head;
    Node newNode;
    int size;


    void addNode(int size) {

        for (int i = 1; i <= size; i++) {
            Node boy = new Node(i);
            if (i == 1) {
                head = boy;
                head.next = head;
                newNode = head;
            } else {
                newNode.next = boy;
                boy.next = head;
                newNode = boy;
            }
        }
    }

    void addNodeExe(int size) {
        this.size = size;
        for (int i = 1; i <= size; i++) {
            Node body = new Node(i);
            if (i == 1) {
                head = body;
                head.next = head;
                newNode = head;
            } else {
                body.next = head;
                newNode.next = body;
                newNode = body;
            }

        }
    }

    void list() {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (true) {
            System.out.println("小孩标号: " + cur.no);

            if (cur.next == head) {
                break;
            }
            cur = cur.next;
        }
    }

    void listExe() {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            System.out.println("小孩标记: " + cur.no);
            if (cur.next == head) {
                break;
            }
            cur = cur.next;
        }
    }

    void start(int start, int m) {
        if (start < 1 || start > size) {
            return;
        }

        Node pre = head;

        //找到最后一个节点
        while (true) {
            if (pre.next == head) {
                break;
            }
            pre = pre.next;
        }

        for (int i = 0; i < start - 1; i++) {
            head = head.next;
            pre = pre.next;
        }

        while (true) {
            if (pre == head) {
                break;
            }

            //m-1代表 当前小孩也算1,所以要-1
            for (int i = 0; i < m - 1; i++) {
                head = head.next;
                pre = pre.next;
            }
            System.out.println("出队小孩为: " + head.no);
            head = head.next;
            pre.next = head;
        }
        System.out.println("最后一个小孩为: " + head.no);
    }

    /**
     * @param start 报数位置
     * @param m     报数个数
     */
    void startExe(int start, int m) {
        if (start < 1 || start > size || head == null) {
            return;
        }

        //初始化head上一个位置
        Node pre = head;
        while (pre.next != null) {
            if (pre.next == head) break;
            pre = pre.next;
        }

        System.out.println("最后一个小孩为: " + pre.no);

        //初始化报数位置
        for (int i = 0; i < start - 1; i++) {
            head = head.next;
            pre = pre.next;
        }

        while (true) {
            if (head == pre) {
                //只剩最后一个
                break;
            }

            for (int k = 0; k < m - 1; k++) {
                head = head.next;
                pre = pre.next;
            }

            System.out.println("出队小孩no为: " + head.no);
            head = head.next;
            pre.next = head;
        }
        System.out.println("最后剩下的小孩为: " + head.no);
    }
}
