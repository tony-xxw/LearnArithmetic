package algorithm.recursion;


/**
 * 递归八皇后
 **/
public class EightQueen {
    int MAXSIZE = 8;
    int[] queen = new int[MAXSIZE];

    static int count;

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.check(0);

        System.out.printf("一共有解法%d种", count);

    }

    public void check(int n) {
        if (n == MAXSIZE) {
            print();
            return;
        } else {
            for (int i = 0; i < MAXSIZE; i++) {
                queen[n] = i;
                //当前列找摆放位置,与互斥点
                if (judge(n)) {
                    //当前没有互斥点,继续下一个
                    check(n + 1);
                }
                //当前点存在互斥点,找同一列另外的点是否存在互斥
            }
        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //(queen[i] == queen[n]  表示为同一列 互相攻击
            //表示为在同一斜线上
            //Math.abs(n - i) == Math.abs(queen[n]) - Math.abs(queen[i])
            // x2- x1 = y2- y1
            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) {
                return false;
            }
        }
        return true;

    }

    private void print() {
        count++;
        for (int i = 0; i < MAXSIZE; i++) {
            System.out.printf("%d", queen[i]);
        }
        System.out.println();
    }

}
