package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *  删除有序数组中的重复项
 */
public class RepetitionArray {
    public static void main(String[] args) {

        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("删除有序数组中的重复项: "+removeDuplicates(ints));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j + 1;
    }
}
