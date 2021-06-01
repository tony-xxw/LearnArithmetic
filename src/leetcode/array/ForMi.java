package leetcode.array;

/**
 * 4的幂
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class ForMi {

    public static void main(String[] args) {

        System.out.println("4的幂: " + isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
