package algorithm.sort;

import java.util.Arrays;

public class RadixSort {


    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

        System.out.println(542/10);

        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        System.out.println("排序后的数组为: " + Arrays.toString(arr));
    }

    private void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCounts = new int[10];




        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + i + "轮 对各位的排序处理arr = " + Arrays.toString(arr));
        }


    }
}
