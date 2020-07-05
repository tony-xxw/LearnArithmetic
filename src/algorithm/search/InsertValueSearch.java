package algorithm.search;


import java.util.Arrays;

/**
 * 前提条件为顺序(连续性很高)
 * 插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        InsertValueSearch insertValueSearch = new InsertValueSearch();
        System.out.printf("查找的值的为%d,下标为%d", 50, insertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 50));
    }


    public int insertValueSearch(int[] array, int left, int right, int findValue) {
        if (left > right || findValue > array[right] || findValue < array[0]) {
            return -1;
        }
        //求mid
        int mid = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);
        int midValue = array[mid];

        if (findValue > midValue) {
            return insertValueSearch(array, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return insertValueSearch(array, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
