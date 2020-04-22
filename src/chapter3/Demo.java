package chapter3;

import chapter3.linked.Node;
import chapter3.linked.SingleLinked;

public class Demo {


    //头结点
    private Node head = new Node("head");


    private void addNode(String content) {
        Node newNode = new Node(content);
        if (head.next == null) {
            head.next = newNode;
            return;
        }

        Node temp = head;
        //下一个结点不为null
        while (temp.next != null) {
            //当前指针后移一位
            temp = temp.next;
        }
        //最后一位添加新结点
        temp.next = newNode;
    }

    private void deleteIndexNode(int index) {
        if (index < 1 || index > getSize()) {
            return;
        }
        Node pre = head;
        Node current = pre.next;
        int size = 1;
        while (current.next != null) {
            if (size == index) {
                //指定结点删除
                pre.next = current.next;
                break;
            }
            size++;
            pre = current;
            current = current.next;
        }

    }

    private int getSize() {
        Node temp = head;
        int size = 1;
        while (temp.next != null) {
            if (!temp.content.equals("head")) {
                size++;
            }
            temp = temp.next;
        }
        return size;
    }

    private void logNode() {
        Node node = head;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.content + "=>");
            } else {
                System.out.print(node.content);
            }

            node = node.next;
        }

    }

    private String obtainIndexNode(int index) {
//        if (index < 1 || index > getSize()) {
//            return "不存在此节点";
//        }
//
//        Node temp = head;
//        int size = 0;
//        while (temp.next != null) {
//            if (size == index) {
//                return temp.content;
//            }
//            size++;
//            temp = temp.next;
//        }
//
//        if (size == getSize() && index == getSize()) {
//            //指针移动到最后一个等于链表长 并且 查询的指针数也等于链表长 证明查询的是最后一个结点 指针
//            return temp.content;
//        }
//
//        return "不存在此节点";
        return "";
    }


    public static void main(String[] args) {
        Demo single = new Demo();
        single.addNode("a");
        single.addNode("b");
        single.addNode("c");
        single.addNode("d");
        single.addNode("e");
        single.addNode("f");
        single.logNode();
        System.out.println();
        System.out.println("size: " + single.getSize());

        single.deleteIndexNode(1);
        single.logNode();
        System.out.println();
        System.out.println("size: " + single.getSize());

//        System.out.println(single.obtainIndexNode(2));
    }
}
