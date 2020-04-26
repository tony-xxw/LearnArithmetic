package chapter3.lineTable.linked;

/**
 * 数据结构-链表-结点
 */
public class Node {
    public Node next = null;// 节点的引用，指向下一个节点
    public int data;// 节点的对象，即内容
    public String content;
    public Node pre;

    public Node(int data) {
        this.data = data;
    }



    public Node(String content) {
        this.content = content;
    }

    public Node( String content,Node next) {
        this.next = next;
        this.content = content;
    }

    public Node(Node next, String content, Node pre) {
        this.next = next;
        this.content = content;
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
