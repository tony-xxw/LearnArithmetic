package algorithm.linked;

public class Node {
    public String name;
    public String nikeName;
    public int no;
    public Node next;
    public Node pre;


    public Node(int no, String name, String nikeName) {
        this.name = name;
        this.nikeName = nikeName;
        this.no = no;
    }

    public Node(int no) {
        this.no = no;

    }

    public Node( String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Node =>  no: " + no + " name: " + name + "    nikeName: " + nikeName;
    }
}
