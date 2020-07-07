package algorithm.tree;

public class ArrBinaryTree {

    private int[] array = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree();
        System.out.println("顺序二叉树前序遍历");
        arrBinaryTree.orderSort();
        System.out.println();
        System.out.println("顺序二叉树中序遍历");
        arrBinaryTree.orderIndexSort();
        System.out.println();
        System.out.println("顺序二叉树后序遍历");
        arrBinaryTree.orderLastSort();
    }

    private void orderSort() {
        orderSort(0);
    }

    private void orderIndexSort() {
        orderIndexSort(0);
    }

    private void orderLastSort() {
        orderLastSort(0);
    }

    private void orderSort(int no) {
        if (no < 0 || no > array.length) {
            return;
        }

        System.out.print(array[no] + ",");

        if ((no * 2 + 1) < array.length) {
            orderSort((no * 2 + 1));
        }

        if ((no * 2 + 2) < array.length) {
            orderSort((no * 2 + 2));
        }

    }

    private void orderIndexSort(int no) {
        if (no < 0 || no > array.length) {
            return;
        }

        if ((no * 2 + 1) < array.length) {
            orderIndexSort((no * 2 + 1));
        }

        System.out.print(array[no] + ",");

        if ((no * 2 + 2) < array.length) {
            orderIndexSort((no * 2 + 2));
        }
    }


    private void orderLastSort(int no) {
        if (no < 0 || no > array.length) {
            return;
        }

        if ((no * 2 + 1) < array.length) {
            orderLastSort((no * 2 + 1));
        }

        if ((no * 2 + 2) < array.length) {
            orderLastSort((no * 2 + 2));
        }

        System.out.print(array[no] + ",");
    }
}
