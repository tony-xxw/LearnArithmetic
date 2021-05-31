package leetcode.array;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 */
public class MobileZero {
    public static void main(String[] args) {
        explain();
    }

    private static void explain() {
        //解法1 双指针
        System.out.println("解法二 双指针");
        int temp1[] = new int[]{0, 1, 0, 3, 12};
        int j = 0;
        for (int i = 0; i < temp1.length; i++) {
            if (temp1[i] != 0) {
                temp1[j++] = temp1[i];
            }
        }
        for (int i = j; i < temp1.length; i++) {
            temp1[i] = 0;
        }
        System.out.println(Arrays.toString(temp1));
        //解法2 优化版
        System.out.println("解法二优化版");
        int zero[] = new int[]{0, 1, 0, 3, 12};
        int jj = 0;
        for (int i = 0; i < zero.length; i++) {
            if (zero[i] != 0) {
                if (i != jj) {
                    zero[jj++] = zero[i];
                    zero[i] = 0;
                }

            }
        }
        System.out.println(Arrays.toString(zero));

        //解法三 快排思路
        System.out.println("解法三 快排思路");
        int[] temp2 = new int[]{1, 3, 0, 0, 12};
        int jjj = 0;
        for (int i = 0; i < temp2.length; i++) {
            if (temp2[i] != 0) {
                int tep = temp2[i];
                temp2[i] = 0;
                temp2[jjj++] = tep;
            }
        }

        System.out.println(Arrays.toString(temp2));
    }

    private static void deliberately() {
        int temp[] = new int[]{1, 0, 0, 3, 12};
        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                int data = temp[i];
                temp[i] = 0;
                temp[index++] = data;
            }
        }
        System.out.println("复习: " + Arrays.toString(temp));
    }

}
