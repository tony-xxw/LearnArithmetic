package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] inset = {101, 34, 119, 1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(inset);
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
            int pre = i - 1;
            while (pre >= 0 && array[pre] > temp) {
                array[pre + 1] = array[pre];
                pre--;
            }

            if (pre + 1 != i) {
                array[++pre] = temp;
            }
            System.out.printf("第%d次排序", i );
            System.out.println(Arrays.toString(array));

        }

    }
}
