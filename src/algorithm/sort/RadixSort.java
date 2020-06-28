package algorithm.sort;

import java.util.Arrays;


/**
 * 基数排序(桶排序)
 */
public class RadixSort {


    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};


        RadixSort radixSort = new RadixSort();
        radixSort.radixSortExer(arr);
        System.out.println("排序后的数组为: " + Arrays.toString(arr));
    }

    private void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //找到数组中最大位
        int maxLength = (max + "").length();
        //创建二维数组 10是因为不会超过10位数,第二位是数组最大长度(容量)
        int[][] bucket = new int[10][arr.length];

        //每一个二位数组对应有几个值
        int[] bucketElementCounts = new int[10];


        //根据个十百遍历
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //获取当前元素的个十百位数
                int digitOfElement = arr[j] / n % 10;
                //将当前元素放入对应位数的二维数组下标,下标值位记录值的第几个位置
                //例如 当前元素位52 个位是2,就放入二位数组下标为2,bucket数组为2的值  arr[2][bucket[2]] = 10 arr[2][0] = 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //存放值以后 记录bucket数组中当前个位下标+1 表示已放数据
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            //将对应二维数组的值,根据放入二维数组的顺序 与原始数组进行替换
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //置空记录数据的数组
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + i + "轮 对各位的排序处理arr = " + Arrays.toString(arr));
        }

    }

    private void radixSortExer(int[] arr) {
        int max = 0;
        //获取最大值
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        //最大位数
        int maxPlace = String.valueOf(max).length();

        //定义二位数组
        int[][] radixArray = new int[10][arr.length];
        //定义记录数组
        int[] recordArray = new int[10];

        //根据百十个位遍历
        for (int i = 0, n = 1; i < maxPlace; i++, n *= 10) {
            //遍历原始数组,插入到而二维数组中
            for (int j = 0; j < arr.length; j++) {
                //获取当前元素的位数
                int place = arr[j] / n % 10;
                radixArray[place][recordArray[place]] = arr[j];
                recordArray[place]++;
            }

            int index = 0;
            //k的下标对应二维数组在第几个index 有存值
            for (int k = 0; k < recordArray.length; k++) {
                //当前数组值不等于0,表示当前下标二维数组有存值
                if (recordArray[k] != 0) {
                    //此循环表示 当前下标有存几次值,需要循环取出
                    for (int l = 0; l < recordArray[k]; l++) {
                        //index++表示旧数组从0到最后需要全部重新赋值
                        arr[index++] = radixArray[k][l];
                    }
                }
                //走完一轮置空 以便下一次记录
                recordArray[k] = 0;
            }

        }

    }
}
