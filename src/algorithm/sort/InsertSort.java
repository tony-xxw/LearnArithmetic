package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] inset = {101, 34, 119, 1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(inset);
    }


    public void insertSort(int[] sort) {


        for (int i = 1; i < sort.length; i++) {
            int cur = sort[i];//1
            int preIndex = i - 1; //2

            while (preIndex >= 0 && sort[preIndex] > cur) {

                //大于后面的数后移
                sort[preIndex + 1] = sort[preIndex];
                //移动后回来
                preIndex--;
            }

            if (preIndex + 1 != i) {
                sort[preIndex + 1] = cur;
            }

            System.out.printf("第%d次排序", i);
            System.out.println(Arrays.toString(sort));
        }
    }
}
