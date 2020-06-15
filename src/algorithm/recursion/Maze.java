package algorithm.recursion;

/**
 * 迷宫问题
 */
public class Maze {

    public static void main(String[] args) {
        int[][] maze = new int[8][7];

        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        //打印迷宫
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

        maze[3][1] = 1;
        maze[3][2] = 1;


        setWay(maze, 1, 1);
        System.out.println("找球");
        //打印迷宫
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //表示找到了出口
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //找球策略 下 右 上 左
                if (setWay(map, i + 1, j)) {
                    //下
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //右
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //上
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //左
                    return true;
                } else {
                    //此路不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false; //可能遇到墙 1 可能走过2 可能走不通3
            }
        }

    }
}
