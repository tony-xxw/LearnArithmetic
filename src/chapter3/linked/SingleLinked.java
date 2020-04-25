package chapter3.linked;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 单链表
 */
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

    private void addNodeFirst(int content){
        Node newNode = new Node(content);
        if (head==null){
            head= newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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

    private String obtainIndexNode(int index) {
        if (index < 0 || index > getSize()) {
            return "不存在此节点";
        }

        Node temp = head;
        int size = 0;
        while (temp.next != null) {
            if (size == index) {
                return temp.data+"";
            }
            size++;
            temp = temp.next;
        }

        if (size == getSize() && index == getSize()) {
            //指针移动到最后一个等于链表长 并且 查询的指针数也等于链表长 证明查询的是最后一个结点 指针
            return temp.data+"";
        }

        return "不存在此节点";
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
        System.out.println("size: "+linked.getSize());

        linked.deleteIndexNode(6);
        linked.printList();
        System.out.println("size: "+linked.getSize());
        System.out.println("查询结点为: "+linked.obtainIndexNode(1));


    }
}
