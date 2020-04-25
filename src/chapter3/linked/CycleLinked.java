package chapter3.linked;

/**
 * 循环链表
 * 单链表的基础上,最后一个结点 等于头结点
 */
public class CycleLinked {

    private Node head;
    private Node tail;
    private int size;


    CycleLinked(String content) {
        head = new Node(content, null);
        tail = head;
        size++;
    }


    CycleLinked() {

    }

    public int getSize() {
        return size;
    }

    private boolean iisEmpty() {
        return size == 0;
    }

    private void deleteNode() {

    }

    private void obtainNode() {

    }

    //从尾部添加
    private void addFooterNode(String content) {
        if (iisEmpty()) {
            head = new Node(content, head);
            tail = head;
        } else {
            Node newNode = new Node(content);
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;

        }
        size++;
    }

    //从头部加  head被排到最后
    private void addHeadNode(String content) {
        if (iisEmpty()) {
            head = new Node(content, head);
            tail = head;
        } else {
            Node newNode = new Node(content);
            newNode.next = head;
            head = newNode;
            tail.next = head;

        }
        size++;

    }


    private void logNode() {
        if (iisEmpty()) {
            System.out.println("[]");
        } else {
            StringBuilder builder = new StringBuilder();
            System.out.println("头部为:" + head.content);
            System.out.println("尾部为:" + tail.content);
            System.out.println("尾部的下一个为头部:" + tail.next.content);
            builder.append(head.content + "=>");
            if (head.next == null) {
                return;
            }
            for (Node node = head.next; node != head; node = node.next) {
                builder.append(node.content + "=>");
            }

            System.out.println(builder.toString());

        }
    }


    public static void main(String[] args) {
        CycleLinked cycleLinked = new CycleLinked("head");
        cycleLinked.addHeadNode("上海");
        cycleLinked.addHeadNode("苏州");
        cycleLinked.addHeadNode("常州");
//

//        System.out.println("size: " + cycleLinked.size);

        cycleLinked.logNode();
    }
}
