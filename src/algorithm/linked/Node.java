package algorithm.linked;

public class Node {
    String name;
    String nikeName;
    int no;
    Node next;
    Node pre;


    public Node(int no, String name, String nikeName) {
        this.name = name;
        this.nikeName = nikeName;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node =>  no: " + no + " name: " + name + " nikeName: " + nikeName;
    }
}
