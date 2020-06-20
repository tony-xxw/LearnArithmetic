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
        selectSort.sort(select);

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
            //默认拿第一个数做对比
            int pre = i;
            int tem = array[i];
            for (int j = i + 1; j < array.length; j++) {
                //当默认值大于后面的数,就后移以为,保留最小数,当遍历完,pre会成为数组里最小的数
                if (tem > array[j]) {
                    tem = array[j];
                    pre = j;
                }
            }
            //当pre 有变动不为默认值,我们将pre最小数 放到第一位
            if (pre != i) {
                array[pre] = array[i];
                array[i] = tem;
            }

            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(array));

        }
    }
}
