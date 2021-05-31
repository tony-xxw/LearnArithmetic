package algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortExercise {

    public static void main(String[] args) {
        int[] arrys = new int[]{1, 2, 5, 11, 33, 6};
        SortExercise sortExercise = new SortExercise();
        System.out.println("冒泡排序");
        sortExercise.bubbling(arrys);
        System.out.println();
        int[] arrys1 = new int[]{14, 12, 445, 113, 33, 6};
        System.out.println("插入排序");
        sortExercise.insert(arrys1);
        System.out.println("递归排序");
        int[] arrys2 = new int[]{14, 12, 445, 113, 33, 6};
        int[] temp = new int[arrys2.length];
        sortExercise.merge(arrys2, 0, arrys2.length - 1, temp);
        System.out.println("快速排序");
        int[] arrys3 = new int[]{10, 4, 8, 5, 1, 7, 3,5};
        sortExercise.quick(arrys3, 0, arrys3.length - 1);
    }

    private void quick(int[] arrys, int left, int right) {
        int l = left;
        int r = right;
        int mid = arrys[(left + right) / 2];
        int cout = 0;

        while (l < r) {

            while (arrys[l] < mid) {
                l++;
            }

            while (arrys[r] > mid) {
                r--;
            }

            if (l >= r) {
                break;
            }


            cout = arrys[r];
            arrys[r] = arrys[l];
            arrys[l] = cout;

            if (arrys[l]== mid){
                r--;
            }
            if(arrys[r] ==mid){
                l++;
            }
            System.out.println( Arrays.toString(arrys));
        }


        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quick(arrys, left, r);
        }

        if (right > l) {
            quick(arrys, l, right);
        }


    }

    private void merge(int[] arrys, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(arrys, left, mid, temp);
            merge(arrys, mid + 1, right, temp);
            hebing(arrys, left, mid, right, temp);
        }
    }

    private void hebing(int[] arrys, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= r && r <= right) {
            if (arrys[l] <= arrys[r]) {
                temp[t] = arrys[l];
                l++;
                t++;
            } else {
                temp[t] = arrys[r];
                t++;
                r++;
            }
        }

        while (l <= mid) {
            temp[t] = arrys[l];
            t++;
            l++;
        }

        while (r <= right) {
            temp[t] = arrys[r];
            t++;
            r++;
        }

        t = 0;
        int tempLeft = left;

        while (tempLeft <= right) {
            arrys[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
        System.out.println(Arrays.toString(arrys));
    }


    private void insert(int[] arrys) {
        for (int i = 1; i < arrys.length; i++) {
            int temp = arrys[i];
            int pre = i - 1;
            while (pre >= 0 && arrys[pre] >= temp) {
                arrys[pre + 1] = arrys[pre];
                --pre;
            }

            if (pre + 1 != i) {
                arrys[++pre] = temp;
            }
            System.out.println(Arrays.toString(arrys));
        }
    }


    private void bubbling(int[] arrys) {
        boolean isExistNoSort = false;

        for (int i = 0; i < arrys.length - 1; i++) {
            for (int j = 0; j < arrys.length - 1 - i; j++) {
                if (arrys[j] > arrys[j + 1]) {
                    isExistNoSort = true;
                    int temp = arrys[j + 1];
                    arrys[j + 1] = arrys[j];
                    arrys[j] = temp;
                }
            }
            System.out.println("第一次遍历后的数组为: " + Arrays.toString(arrys));
            if (!isExistNoSort) {
                break;
            } else {
                isExistNoSort = false;
            }
        }
        System.out.println("排序后结果为: " + Arrays.toString(arrys));
    }
}
