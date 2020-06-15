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
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //走过了 记录为2
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    System.out.println("此路不通");
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
