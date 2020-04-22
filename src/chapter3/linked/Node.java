package chapter3.linked;

/**
 * 数据结构-链表-结点
 */
public class Node {
    Node next = null;// 节点的引用，指向下一个节点
    int data;// 节点的对象，即内容

    public Node(int data) {
        this.data = data;
    }
}
