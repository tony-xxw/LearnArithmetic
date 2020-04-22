package chapter3.linked;

import sun.dc.pr.PRError;

public class SingleLinked {


    //头结点
    private Node head;

    private void addNode(int d) {
        //创建一个需要增加的链表
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    private void deleteIndexNode(int index) {
        if (index < 0 || index > getSize()) {
            return;
        }

        Node preNode = head;
        Node curNode = preNode.next;
        int i = 2;
        while (curNode != null) {
            //找到结点
            if (i == index) {
                preNode.next = curNode.next;
                return;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
    }


    private void printList() {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + "=>");
            } else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    private int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    public static void main(String[] args) {
        SingleLinked linked = new SingleLinked();
        linked.addNode(1);
        linked.addNode(2);
        linked.addNode(3);
        linked.addNode(4);
        linked.addNode(5);
        linked.addNode(6);
        linked.addNode(7);
        linked.printList();

        System.out.println();
        System.out.println(linked.getSize());

        linked.deleteIndexNode(6);
        linked.printList();
        System.out.println();
        System.out.println(linked.getSize());


    }
}
