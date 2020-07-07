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

//        System.out.println("前序遍历");  //1,2,3,5,4
//        binaryTree.findPreOrder();
//        System.out.println("中序遍历"); // 2,1,5,3,4
//        binaryTree.findIndexOrder();
//        System.out.println("后序遍历"); // 2,5,4,3,1
//        binaryTree.findLastOrder();
//
//        System.out.println("前序查找");
//        System.out.println(binaryTree.seekPreOrder(5));
//        System.out.println("中序查找");
//        System.out.println(binaryTree.seekIndexOrder(5));
//        System.out.println("后序查找");
//        System.out.println(binaryTree.seekLastOrder(5));
        System.out.println("删除前遍历");
        binaryTree.findPreOrder();
        binaryTree.delOrder(2);
        System.out.println("删除后遍历");
        binaryTree.findPreOrder();
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


    /**
     * 前序查找
     */
    BinaryNode seekPreOrder(int no) {
        if (root == null) {
            System.out.println("数为空");
            return null;
        }
        return root.seekPreOrder(no);
    }

    /**
     * 中序查找
     */
    BinaryNode seekIndexOrder(int no) {
        if (root == null) {
            System.out.println("数为空");
            return null;
        }
        return root.seekIndexOrder(no);
    }

    /**
     * 后序查找
     */
    BinaryNode seekLastOrder(int no) {
        if (root == null) {
            System.out.println("数为空");
            return null;
        }
        return root.seekLastOrder(no);

    }


    /**
     * 后序查找
     */
    void delOrder(int no) {
        if (root == null) {
            System.out.println("数为空");
            return;
        }

        if (root.id == no) {
            root = null;
        }else {
            root.delOrder(no);
        }

    }

}
