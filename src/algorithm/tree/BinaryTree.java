package algorithm.tree;

import algorithm.tree.binary.BinaryNode;

public class BinaryTree {

    private BinaryNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryNode root = new BinaryNode("宋江", 1);
        BinaryNode root1 = new BinaryNode("吴用", 2);
        BinaryNode root2 = new BinaryNode("卢俊义", 3);
        BinaryNode root3 = new BinaryNode("林冲", 4);
        BinaryNode root4 = new BinaryNode("向鲜汶", 5);

        root.setPreNode(root1);
        root.setNextNode(root2);
        root2.setNextNode(root3);
        root2.setPreNode(root4);

        binaryTree.setRoot(root);

        System.out.println("前序遍历");  //1,2,3,5,4
        binaryTree.findPreOrder();
        System.out.println("中序遍历"); // 2,1,5,3,4
        binaryTree.findIndexOrder();
        System.out.println("后序遍历"); // 2,5,4,3,1
        binaryTree.findLastOrder();
    }

    void setRoot(BinaryNode node) {
        root = node;
    }

    /**
     * 前序遍历
     */
    void findPreOrder() {
        if (root == null) {
            System.out.println("数为空");
            return;
        }
        root.findPreOrder();
    }

    /**
     * 中序遍历
     */
    void findIndexOrder() {
        if (root == null) {
            System.out.println("数为空");
            return;
        }
        root.findIndexOrder();
    }

    /**
     * 后序遍历
     */
    void findLastOrder() {
        if (root == null) {
            System.out.println("数为空");
            return;
        }
        root.findLastOrder();

    }
}