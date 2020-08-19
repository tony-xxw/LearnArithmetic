package leetcode.array;

public class ClimbLadder {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int num = climbStairs1(i);
            System.out.println(i + "----------" + num);
        }
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public static int climbStairs1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] ee = new int[n + 1];
        ee[0] = 1;
        ee[1] = 1;
         for (int i = 2; i < ee.length; i++) {
             ee[i] = ee[i - 1] + ee[i - 2];
        }
        return ee[n];
    }
}
