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

    private void check(int n) {
        if (n == MAXSIZE) {
            print();
            return;
        } else {
            for (int i = 0; i < MAXSIZE; i++) {
                queen[n] = i;
                //当前皇后是否存在冲突
                if (judge(n)) {
                    //没有冲突开始放下一个皇后,因为一个皇后会找8个点,如果成功又会走8个,最后成功就是最终解法
                    check(n + 1);
                }
                //如果当前皇后在当前坐标存在冲突,重新循环查看下一个是否冲突
            }
        }

    }

    private boolean judge(int n) {
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
        for (int i = 0; i < queen.length; i++) {
            System.out.print("" + queen[i]);
        }
        count++;
        System.out.println();
    }


}
