package leetcode.array;

/**
 * 爬楼梯
 */
public class ClimbLadder {
    public static void main(String[] args) {
        int step = 2;
//        fetchStep(2);
    }

    public static int fetchStep(int n) {
        if (n == (n - 1) + (n - 2)) {
            n = n - 1;
            fetchStep(n);
        }
        return n;
    }

}
