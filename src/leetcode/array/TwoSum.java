package leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] temp = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum1(temp, 13)));
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

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //当前哈希表存在一个相加等 目标值的key
            if (map.containsKey(target - nums[i])) {
                //存在相加等于标值的key ,  返回相加的角标鱼当前角标
                return new int[]{map.get(target - nums[i]), i};
            }
            //不存在  以值为key,下标为value 存入map中
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
