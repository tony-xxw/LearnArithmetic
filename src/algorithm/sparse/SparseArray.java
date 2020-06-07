package algorithm.sparse;

public class SparseArray {

    public static void main(String[] args) {
        input();
    }


    private static void input() {
        //创建一个 9x9 的 二维数组棋盘

        int[][] chess = new int[9][9];
        //给棋盘落字 0: 无子 1 黑子 2 白字

        chess[1][3] = 1;
        chess[1][4] = 1;
        chess[2][5] = 2;

        printChess(chess);

        //落子数
        int chessCount = 0;
        //遍历二维数组 获取落子个数
        for (int[] ints : chess) {
            for (int anInt : ints) {
                if (anInt != 0) chessCount++;
            }
        }
        System.out.println("落子数\t" + chessCount);

        //稀疏数组行数
        int sparseCount = 0;
        //创建稀疏数组
        int[][] sparseArray = new int[chessCount + 1][3];
        //给第一行稀疏数组赋值
        sparseArray[sparseCount][0] = chess.length;
        sparseArray[sparseCount][1] = chess.length;
        sparseArray[sparseCount][2] = chessCount;
        printChess(sparseArray);
        //稀疏数组保存
        for (int i = 1; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] != 0) {
                    sparseCount++;
                    sparseArray[sparseCount][0] = i;
                    sparseArray[sparseCount][1] = j;
                    sparseArray[sparseCount][2] = chess[i][j];
                }
            }
        }
        System.out.println("稀疏后的棋盘");
        printChess(sparseArray);

        //稀疏数组 换算回原棋盘
        int[][] chess2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        System.out.println("转回原始棋盘大小行列");
        printChess(chess2);
        System.out.println("转回原始棋盘数据");
        for (int i = 1; i < sparseArray.length; i++) {
            chess2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        printChess(chess2);


    }

    private static void printChess(int[][] chess) {

        for (int[] col : chess) {
            for (int item : col) {
                System.out.print("\t" + item);
            }
            System.out.println();
        }
    }
}
