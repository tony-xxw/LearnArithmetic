package algorithm.tree.hash;

public class EmpNode {
    public String name;
    public int id;
    public EmpNode next;


    public EmpNode(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id + "  name='" + name;
    }
}
