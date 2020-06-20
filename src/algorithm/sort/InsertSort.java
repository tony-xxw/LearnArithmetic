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


    public void insertSort(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            int pre = i - 1;
            int temp = sort[i];
            while (pre >= 0 && sort[pre] > temp) {
                sort[pre + 1] = sort[pre];
                pre--;
            }


            //进入这里的条件 是 pre 到最前面后 置换位置
            if (pre + 1 != i) {
                sort[pre + 1] = temp;
            }

            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(sort));
        }
    }
}
