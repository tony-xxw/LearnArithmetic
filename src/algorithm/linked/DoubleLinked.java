package algorithm.linked;

import java.util.Stack;

public class DoubleLinked {

    private Node head = new Node(0, "", "");
    private int size = 0;

    public String getSize() {
        return "链表长度为: " + size;
    }

    void addNode(Node newNode) {

        if (newNode == null) {
            System.out.println("添加的结点不能为空");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        size++;
        newNode.pre = temp;
        temp.next = newNode;
    }

    void deleteNode(Node node) {
        if (node == null) {
            System.out.println("添加的结点不能为空");
            return;
        }

        if (head.next == null) {
            System.out.println("链表不能为空");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                //要删除的结点
                temp.next.pre = temp.next;
                if (temp.next.no != size) {
                    temp.next = temp.next.next;
                }

                break;

            } else {
                temp = temp.next;
            }
        }
    }

    void updateNode(Node node) {
        if (node == null) {
            System.out.println("添加的结点不能为空");
            return;
        }

        if (head.next == null) {
            System.out.println("链表不能为空");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                temp.next.name = node.name;
                temp.next.nikeName = node.nikeName;
            }
            temp = temp.next;
        }
    }

    void addOrderNode(Node node) {
        if (node == null) {
            System.out.println("添加的结点不能为空");
            return;
        }

        Node temp = head;
        boolean isJoin = false;
        while (temp.next != null) {
            //当前结点小于 加入结点
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                isJoin = true;
                break;
            }
            temp = temp.next;
        }
        if (isJoin) {
            System.out.println("当前英雄已在排名，无需反复添加");
        } else {
            //加入结点插入到当前结点前面,当前结点后移
            size++;
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;

        }
    }

    void list() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }


}
