package algorithm.tree.binary;

public class BinaryNode {
    public String name;
    public int id;
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


    /**
     * 前序查找
     */
    public BinaryNode seekPreOrder(int no) {

        System.out.println("前序查找次数");
        if (this.id == no) {
            return this;
        }
        BinaryNode temp = null;


        if (getPreNode() != null) {
            temp = getPreNode().seekPreOrder(no);
        }

        if (temp != null) {
            return temp;
        }

        if (getNextNode() != null) {
            temp = getNextNode().seekPreOrder(no);
        }
        return temp;
    }

    /**
     * 中序遍历
     */
    public BinaryNode seekIndexOrder(int no) {


        BinaryNode temp = null;


        if (getPreNode() != null) {
            temp = getPreNode().seekIndexOrder(no);
        }

        if (temp != null) {
            return temp;
        }

        System.out.println("中序查找次数");
        if (this.id == no) {
            return this;
        }


        if (getNextNode() != null) {
            temp = getNextNode().seekIndexOrder(no);
        }
        return temp;
    }

    /**
     * 后序遍历
     */
    public BinaryNode seekLastOrder(int no) {
        BinaryNode temp = null;


        if (getPreNode() != null) {
            temp = getPreNode().seekLastOrder(no);
        }

        if (temp != null) {
            return temp;
        }


        if (getNextNode() != null) {
            temp = getNextNode().seekLastOrder(no);
        }
        if (temp != null)
            return temp;

        System.out.println("后序查找次数");
        if (this.id == no) {
            return this;
        }

        return null;

    }

    public void delOrder(int no) {

        if (getPreNode() != null && getPreNode().id == no) {
            setPreNode(null);
            return;
        }

        if (getPreNode() != null) {
            getPreNode().delOrder(no);
        }


        if (getNextNode() != null && getNextNode().id == no) {
            setNextNode(null);
            return;
        }

        if (getNextNode() != null) {
            getNextNode().delOrder(no);
        }



    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
