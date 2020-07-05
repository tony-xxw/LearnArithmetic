package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 8, 1000, 1000, 10, 74, 80, 89, 1000, 1234};

        BinarySearch search = new BinarySearch();
        search.searchExe(arr, 0, arr.length - 1, 1000);

    }

    private void search(int[] arr, int left, int right, int result) {
        int mid = (left + right) / 2;

        if (result > arr[mid]) {
            search(arr, mid + 1, right, result);

        } else if (result < arr[mid]) {
            search(arr, left, mid - 1, result);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[mid]) {
                    list.add(i);
                }
            }
        }
    }

    private void searchExe(int[] array, int left, int right, int result) {
        int mid = (left + right) / 2;

        if (result > array[mid]) {
            searchExe(array, mid + 1, right, result);
        } else if (result < array[mid]) {
            searchExe(array, left, mid - 1, result);
        } else {
            //找到最终与结果匹配的mid
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == array[mid]) {
                    arrayList.add(i);
                }
            }
            System.out.println("找到的数位置是: " + arrayList.toString());

        }
    }
}
