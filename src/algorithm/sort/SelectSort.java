package algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] select = {101, 34, 119, 1, 2, 52, 57, 99, 74};

        SelectSort selectSort = new SelectSort();
        selectSort.sortExe(select);

//        selectSort.test();
    }

    private void test() {
        int[] test = new int[80000];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间为:" + dateFormat.format(new Date()));
        sort(test);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序后的时间为:" + dateFormat1.format(new Date()));
    }


    private void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            int minIndex = i;

            for (int k = i + 1; k < array.length; k++) {
                //找到最小值
                if (temp > array[k]) {
                    temp = array[k];
                    minIndex = k;
                }
            }

            //一轮结束 找到最小值后, 把最小值赋值到最前面
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = temp;
            }

            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(array));
        }
    }

    private void sortExe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int oldData = array[i];
            int oldIndex = i;
 
            for (int k = i + 1; k < array.length; k++) {
                if (oldData > array[k]) {
                    oldData = array[k];
                    oldIndex = k;
                }
            }

            if (oldIndex != i) {
                array[oldIndex] = array[i];
                array[i] = oldData;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
