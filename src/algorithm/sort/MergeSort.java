package algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arry = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arry.length];
        MergeSort sort = new MergeSort();

        sort.mergeSort(arry, 0, arry.length - 1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arry));

    }


    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        //左下标小于右下标才一直分解
        if (left < right) {
            int mid = (left + right) / 2;
            //从左便开始分解
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //分到左右指针差1开始合并
            merge(arr, left, mid, right, temp);
        }

    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("arr: "+Arrays.toString(arr)+" left: "+ left +" mid: " + mid+" right: " + right +" temp: "+ Arrays.toString(temp));
        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }

        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }

        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }

    private void merge1(int[] arry, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边数组开始递归排序
            merge1(arry, left, mid, temp);
            //右边数组递归排序
            merge1(arry, mid + 1, right, temp);
            //左右递归完 最后合并排序
            mergeSort1(arry, left, mid, right, temp);
        }
    }

    private void mergeSort1(int[] arry, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0; //新数组下标

        while (i <= mid && j <= right) {
            if (arry[i] < arry[j]) {
                temp[t] = arry[i];
                i++;
            } else {
                temp[t] = arry[j];
                j++;
            }
            t++;
        }

        while (i <= mid) {
            temp[t] = arry[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = arry[j];
            j++;
            t++;
        }

        //将排好序的temp 赋值到原数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arry[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }

}
