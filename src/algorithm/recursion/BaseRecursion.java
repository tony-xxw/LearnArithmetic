package algorithm.recursion;

/**
 * 递归基础
 */
public class BaseRecursion {


    public static void main(String[] args) {
        bigToSmall(10);
        System.out.println();
        System.out.println(multiplication(5));
    }


    //打印问题,从大到小
    public static void bigToSmall(int n) {
        if (n > 1) {
            bigToSmall(n - 1);
        }
        System.out.println("n = " + n);

    }

    public static int multiplication(int n) {

        int result = 1;
        if (n > 1) {
            result = multiplication(n - 1) * n;
        }
        return result;

    }
}
