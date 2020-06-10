package algorithm.linked;

import java.util.Stack;

public class SingleLinked {
    public Node head = new Node(0, "", "");
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
                temp.next = temp.next.next;
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
        }
    }

    void list() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 链表反转
     */
    void reverse() {

        Node cur = head.next;
        Node next;
        Node reverse = null;

        while (cur != null) {
            //记录当前节点的下个节点
            next = cur.next;
            //当前节点的下一个节点 存入新链表
            cur.next = reverse;
            //新链表赋值
            reverse = cur;
            //当前节点为下一个节点 继续遍历
            cur = next;
        }

        head.next = reverse;
    }

    /**
     * 逆向打印
     */
    void reverseLog() {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur.next != null) {
            System.out.println("压入数据为: " + cur.next.name);
            stack.push(cur.next);
            cur = cur.next;
        }

        System.out.println("栈长: " + stack.size());

        while (!stack.empty()) {
            System.out.println("弹出为: " + stack.pop());
        }
    }

    void bottomIndex(int index) {
        if (size == 0) {
            System.out.println("请先添加节点");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == size - (index - 1)) {
                System.out.print(temp.next);
                break;
            }
            temp = temp.next;
        }
    }

    SingleLinked mergeLinkedList(SingleLinked singleLinked) {
        if (singleLinked == null) {
            return null;
        }
        Node temp = head;
        Node temp1 = singleLinked.head;
        SingleLinked newLinked = new SingleLinked();

        while (temp.next != null) {
            Node node = new Node(temp.next.no, temp.next.name, temp.next.nikeName);
            newLinked.addOrderNode(node);
            temp = temp.next;
        }

        while (temp1.next != null) {
            Node node = new Node(temp1.next.no, temp1.next.name, temp1.next.nikeName);
            newLinked.addOrderNode(node);
            temp1 = temp1.next;
        }
        return newLinked;
    }
}
