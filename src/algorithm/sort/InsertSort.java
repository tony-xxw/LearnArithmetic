package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] inset = {101, 34, 119, 1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(inset);
    }


    public void insertSort(int[] sort) {
        int temp = 0;
        for (int i = 0; i < sort.length - 1; i++) {
            for (int k = 0; k < sort.length - 1 - i; k++) {
                if (sort[k] > sort[k + 1]) {
                    temp = sort[k];
                    sort[k] = sort[k + 1];
                    sort[k + 1] = temp;
                }
            }
            System.out.printf("第%d次遍历", i);
            System.out.println("数组为: " + Arrays.toString(sort));
        }
    }
}
