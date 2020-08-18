package leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MobileZero {
    public static void main(String[] args) {
//        暴力解法
        System.out.println("解法一 暴力解决");
        Integer temp[] = new Integer[]{1, 0, 0, 3, 12};
        List<Integer> arrayList = Arrays.asList(temp);
        List tempList = new ArrayList<>();
        int zeroCount = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            int value = arrayList.get(i);
            if (value != 0) {
                tempList.add(value);
            } else {
                zeroCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            tempList.add(0);
        }
        System.out.println(tempList);


        //解法二 双指针
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
        //解法二 优化版
        System.out.println("解法二优化版");
        int zero[] = new int[]{0, 1, 0, 3, 12};
        int jj = 0;
        for (int i = 0; i < zero.length; i++) {
            if (zero[i] != 0) {
                if (i != jj) {
                    zero[jj] = zero[i];
                    zero[i] = 0;
                }
                jj++;
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
}
