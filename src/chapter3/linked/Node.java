package chapter3.linked;

/**
 * 数据结构-链表-结点
 */
public class Node {
    public Node next = null;// 节点的引用，指向下一个节点
    public int data;// 节点的对象，即内容
    public String content;

    public Node(int data) {
        this.data = data;
    }

    public Node(String content) {
        this.content = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
