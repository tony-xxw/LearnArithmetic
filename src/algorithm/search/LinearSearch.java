package algorithm.search;


/**
 * 线性查找
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] linear = {1, 4, 6, 8, 9, 25, 67, 99};

        int search = 25;
        int res = -1;

        for (int i = 0; i < linear.length; i++) {
            if (linear[i] == search) {
                res = i;
                break;
            } else {
                res = -1;
            }
        }

        if (res == -1) {
            System.out.println("数组中不存在这个数");
        } else {
            System.out.printf("数组中这个数在%d位置上", res);
        }
    }
}
