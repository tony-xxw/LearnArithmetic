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
//        selectSort.sort(select);

        selectSort.test();
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
            int pre = i;
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (temp > array[j]) {
                    temp = array[j];
                    pre = j;
                }
            }
            if (pre != i) {
                array[pre] = array[i];
                array[i] = temp;
            }
//            System.out.printf("第%d次排序", i + 1);
//            System.out.println(Arrays.toString(array));

        }

    }
}
