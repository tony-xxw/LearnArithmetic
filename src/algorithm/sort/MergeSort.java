package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arry = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arry.length];
        MergeSort sort = new MergeSort();

        sort.merge1(arry, 0, arry.length - 1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arry));

    }


    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            System.out.println("left=" + left + " right= " + right);
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("merge array = " + Arrays.toString(arr) + " left=" + left + " mid= " + mid + " right= " + right);
        int i = left;
        int j = mid + 1;
        int t = 0; //temp数组下标

        //左边与右边都未到达最后
        while (i <= mid && j <= right) {
            //左数组当前下标小于右数组, 则把当前左数组元素加入新的数组
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                //反之右数组元素插入新的数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }


        //将剩余的左边元素加入到临时数组
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        //将剩余的右边数组加入到临时数组
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }


        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

    private void merge1(int[] arry, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边数组开始递归排序
            merge1(arry,left,mid,temp);
            //右边数组递归排序
            merge1(arry,mid+1,right,temp);
            //左右递归完 最后合并排序
            mergeSort1(arry,left,mid,right,temp);
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
