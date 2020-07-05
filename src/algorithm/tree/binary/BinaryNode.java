package algorithm.tree.binary;

public class BinaryNode {
    private String name;
    private int id;
    private BinaryNode preNode;
    private BinaryNode nextNode;

    public BinaryNode(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public BinaryNode getPreNode() {
        return preNode;
    }

    public BinaryNode getNextNode() {
        return nextNode;
    }

    public void setPreNode(BinaryNode preNode) {
        this.preNode = preNode;
    }

    public void setNextNode(BinaryNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * 前序遍历
     */
    public void findPreOrder() {

        System.out.println(this);

        if (getPreNode() != null) {
            getPreNode().findPreOrder();
        }

        if (getNextNode() != null) {
            getNextNode().findPreOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void findIndexOrder() {


        if (getPreNode() != null) {
            getPreNode().findIndexOrder();
        }

        System.out.println(this);

        if (getNextNode() != null) {
            getNextNode().findIndexOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void findLastOrder() {
        if (getPreNode() != null) {
            getPreNode().findLastOrder();
        }
        if (getNextNode() != null) {
            getNextNode().findLastOrder();
        }

        System.out.println(this);

    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
