package algorithm.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private boolean isSort = false;

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] bubble = {10, 4, 3, -1, 5, 7};

        bubbleSort.sortExe(bubble);
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

    private void sort(int[] bubble) {
        for (int i = 0; i < bubble.length - 1; i++) {

            for (int j = 0; j < bubble.length - 1 - i; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    isSort = true;
                    int temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(bubble));

            if (!isSort) {
                break;
            } else {
                isSort = false;
            }
        }
    }


    private void sortExe(int[] bubble) {
        boolean isSort = false;
        for (int i = 0; i < bubble.length - 1; i++) {
            for (int j = 0; j < bubble.length - 1 - i; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    isSort = true;
                    int temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
            if (!isSort) {
                break;
            } else {
                isSort = false;
            }

            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(bubble));
        }
    }
}
