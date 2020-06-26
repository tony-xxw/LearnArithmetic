package algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] select = {101, 34, 119, 1, 2, 52, 57, 99, 74};

        ShellSort shellSort = new ShellSort();
        shellSort.sortQuick(select);
//        shellSort.test();
    }

    private void sort(int[] array) {

        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
//                System.out.print(" i=" + i);
//                System.out.print(" gap=" + gap);
                for (int j = i - gap; j >= 0; j -= gap) {
//                    System.out.println(" j=" + j + "  array[j] > array[j + gap] " + (array[j] > array[j + gap]));
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
//            System.out.println("第" + gap + "轮" + Arrays.toString(array));
        }
    }

    private void sortQuick(int[] array) {
//        System.out.println(Arrays.toString(array));
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
//                System.out.println("xxx");
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
//                        System.out.println(Arrays.toString(array));
//                        System.out.println("j= " + j);
//                        System.out.println("array[j]= " + array[j]);
//                        System.out.println("array[j - gap]= " + array[j - gap]);
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
//            System.out.println("第" + gap + "轮" + Arrays.toString(array));

        }
    }

    private void test() {
        int[] test = new int[80000];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间为:" + dateFormat.format(new Date()));
        sortQuick(test);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序后的时间为:" + dateFormat1.format(new Date()));
    }
}
