package algorithm.linked;

import java.util.LinkedList;

/**
 * 链表的约瑟夫问题
 * 有N个小孩,围绕成一个圈,从1依次开始报数,数到的M小孩出队。下位又是从1报数,数到M出列,依次类推到结束.求出队队列
 */
public class JosephLinkedList {

    Node head;
    Node last;
    int m;
    Node newNode;
    Node oldNode;
    int size;
    int start = 1;


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

    void start(int start, int m, int total) {
        if (start < 1 || start > total) {
            return;
        }

        Node pre = head;

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
}
