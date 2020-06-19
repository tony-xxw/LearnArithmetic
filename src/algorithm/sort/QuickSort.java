package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 8, 5, 3, 11, 2, 1};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
    }


    private void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int povit = arr[(left + right) / 2];
        int temp = -1;

        System.out.println("中位数值为:" + povit);
        System.out.println("排序前的数组为: " + Arrays.toString(arr));
        //左指针小于右指针 说明左序列并不是都小于中位数,右序列并不是都大于中位数
        while (l < r) {

            while (arr[l] <= povit) {
                l++;
            }

            while (arr[r] >= povit) {
                r--;
            }

            /*
             *当如上两个循环都已经退出
             * 说明左边指针指向的元素 有大于中位数的值
             * 右指针有小于中位数的值
             * 所以需要置换
             */

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            /*
             * 当l==r 说明左右序列已经排列完成,
             * 需要把左指针改为右序列的第一个 所有要+1,
             * 同理右指针要成为做左序列的最后一个要-1
             * */
            if (l == r) {
                r--;
                l++;
            }

        }
        System.out.println("排序后的数组为: " + Arrays.toString(arr));


    }
}
