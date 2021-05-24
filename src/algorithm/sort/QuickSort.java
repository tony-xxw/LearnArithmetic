package algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 8, 5, 1, 7, 3, 11, 2, 5};

        QuickSort quickSort = new QuickSort();
        System.out.println("原始数据: " + Arrays.toString(arr));
        quickSort.sortExe(arr, 0, arr.length - 1);
//        quickSort.test();
    }

    private void test() {
        int[] test = new int[80000];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间为:" + dateFormat.format(new Date()));
        sort(test, 0, test.length - 1);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序后的时间为:" + dateFormat1.format(new Date()));
    }


    private void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int povit = arr[(left + right) / 2];
        int temp = 0;
//        System.out.println("中位数值为:" + povit);
//        System.out.println("排序前的数组为: " + Arrays.toString(arr));
        //左指针小于右指针 说明左序列并不是都小于中位数,右序列并不是都大于中位数
        while (l < r) {

            while (arr[l] < povit) {
                l += 1;
            }

            while (arr[r] > povit) {
                r -= 1;
            }


            //第一次排序已经完成,要递归左右顺序
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;


            //如果相等 说明可能存在重复数字,需要移动,这样l就会大于r 停止循环
            if (arr[l] == povit) {
                r -= 1;
            }

            if (arr[r] == povit) {
                l += 1;
            }


        }
        System.out.println("排序后的数组为: " + Arrays.toString(arr));


        /*
         * 当l==r 说明左右序列已经排列完成,
         * 需要把左指针改为右序列的第一个 所有要+1,
         * 同理右指针要成为做左序列的最后一个要-1
         * */
        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            sort(arr, left, r);
        }

        if (right > l) {
            sort(arr, l, right);
        }

    }

    private void sortExe(int[] array, int left, int right) {

        int l = left;
        int r = right;
        int mid = array[(left + right) / 2];
        System.out.println("left "+ left + " right " + right+" mid "+mid);

        int temp = 0;

        while (l < r) {
            while (array[l] < mid) {
                l++;
            }

            while (array[r] > mid) {
                r--;
            }

            if (l >= r) {
                break;
            }

            temp = array[l];
            array[l] = array[r];
            array[r] = temp;


            if (array[l] == mid) {
                r--;
            }

            if (array[r] == mid) {
                l++;
            }

        }

        System.out.println("排序后的数组为: " + Arrays.toString(array));

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            sortExe(array, left, r);
        }

        if (right > l) {
            sortExe(array, l, right);
        }
    }
}
