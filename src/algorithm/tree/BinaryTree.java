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

//        System.out.println("前序查找");
//        System.out.println(binaryTree.seekPreOrder(5));
//        System.out.println("中序查找");
//        System.out.println(binaryTree.seekIndexOrder(5));
//        System.out.println("后序查找");
//        System.out.println(binaryTree.seekLastOrder(5));
//        System.out.println("删除前遍历");
//        binaryTree.findPreOrder();
//        binaryTree.delOrder(2);
//        System.out.println("删除后遍历");
//        binaryTree.findPreOrder();

//        System.out.println("中序遍历"); // 2,1,5,3,4
//        binaryTree.findIndexOrder();
        binaryTree.clubsTree();
//        System.out.println("next 2");
//        System.out.println(root1.getNextNode());
//        System.out.println("pre 1");
//        System.out.println(root.getPreNode());
//        System.out.println("pre 5");
//        System.out.println(root4.getPreNode());
//        System.out.println("next 5");
//        System.out.println(root4.getNextNode());
//        System.out.println("pre 3");
//        System.out.println(root3.getPreNode());
//        System.out.println("next 3");
//        System.out.println(root3.getNextNode());
//        System.out.println("pre 4");
//        System.out.println(root3.getPreNode());
//        System.out.println("next 4");
//        System.out.println(root3.getNextNode());
        binaryTree.clubsTraverse();
    }


    void setRoot(BinaryNode node) {
        root = node;
    }

    void clubsTree() {
        if (root == null) {
            System.out.println("数为空");
            return;
        }
        root.cluesTree(root);

    }

    void clubsTraverse() {

        while (root != null) {
            //如果没有线索化一直遍历
            while (root.getPreType() == 0) {
                root = root.getPreNode();
            }
            //找到type=1的节点
            System.out.println(root);

            while (root.getRightType() == 1) {
                root = root.getNextNode();
                System.out.println(root);
            }

            root = root.getNextNode();
        }

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
        } else {
            root.delOrder(no);
        }

    }

}
