package leetcode.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 力扣（LeetCode）
 * https://leetcode-cn.com/problems/container-with-most-water
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class ContainerWater {
    public static void main(String[] args) {
        int[] container = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        //暴力解法
//        System.out.println("解法1 暴力解决");
//        System.out.println(fetchMaxRange(container));
        //由于水面面积等于 底长* 板长, 如果左右指针的新短板都无法大于旧短板,则面基比小于旧面基
        System.out.println("解法2 双指针");
        System.out.println(deliberately(container));
    }

    private static int fetchMaxRange2(int[] array) {

        int l = 0, r = array.length - 1, max = 0;

        while (l < r) {
            max = array[l] < array[r] ?
                    Math.max(max, calculateRange(l++, r, array)) :
                    Math.max(max, calculateRange(l, r--, array));
        }
        return max;
    }

    private static int fetchMaxRange(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                int current = calculateRange(i, j, array);
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

    private static int calculateRange(int i, int j, int[] array) {
        // 长 等于 j -i , 高度要取小值(因为不能有斜容器)
        return (j - i) * Math.min(array[i], array[j]);
    }

    private static int deliberately(int[] n) {
        int max = 0;
        int l = 0, r = n.length - 1;

//        for (int i = 0; i < n.length; i++) {
//            for (int j = i + 1; j <= n.length - 1; j++) {
//                max = Math.max(max, calculateRange(i, j, n));
//            }
//        }
        while (l < r) {
            max = n[l] < n[r] ? Math.max(max, calculateRange(l++, r, n)) :
                    Math.max(max, calculateRange(l, r--, n));
        }
        return max;
    }
}
