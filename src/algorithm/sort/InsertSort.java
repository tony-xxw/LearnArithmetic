package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] inset = {101, 1,34, 119, 2};
        InsertSort insertSort = new InsertSort();
        insertSort.sortExe(inset);
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int pre = i - 1;
            while (pre >= 0 && array[pre] > temp) {
                array[pre + 1] = array[pre];
                pre--;
            }

            if (pre + 1 != i) {
                array[++pre] = temp;
            }
            System.out.printf("第%d次排序", i);
            System.out.println(Arrays.toString(array));
        }
    }

    public void sortExe(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int index = i - 1;
            while (index >= 0 && array[index] > temp) {
                array[index + 1] = array[index];
                //回到置换前
                index--;
            }


            if (index + 1 != i) {
                array[++index] = temp;
            }
            System.out.printf("第%d次排序", i);
            System.out.println(Arrays.toString(array));

        }
    }
}
