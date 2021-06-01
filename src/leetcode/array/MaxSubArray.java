package leetcode.array;

/**
 * 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * TODO 动态规划 周四复习
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] temps = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大子序和: " + maxSubArray(temps));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
