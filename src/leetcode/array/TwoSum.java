package leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] temp = new int[]{2, 11, 21, 15};

        System.out.println(Arrays.toString(twoSum1(temp, 23)));
    }


    /**
     * 暴力法
     * 时间复杂 f(o) = n²
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 哈希表
     * f(o)= n
     */
    public static int[] twoSum1(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
