package algorithm.recursion;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * 迷宫问题
 */
public class Maze {

    public static void main(String[] args) {
        Maze mazeObj = new Maze();
        //创建一个8x8的迷宫
        int[][] maze = mazeObj.createMaze();
        //设置障碍
        maze[3][1] = 1;
        maze[3][2] = 1;
        mazeObj.printMaze(maze);
        mazeObj.setWayExe(maze, 1, 1);
        System.out.println("迷宫路线");
        mazeObj.printMaze(maze);
    }

    public boolean setWay(int[][] maze, int i, int j) {
        if (maze[5][6] == 2) {
            //到达目标点
            return true;
        } else {
            if (maze[i][j] == 0) {
                //表示可以走这条路
                maze[i][j] = 2;
                //2表示走过
                //走的方向为下,右,上,左
                if (setWay(maze, i + 1, j)) {
                    return true;
                } else if (setWay(maze, i, j + 1)) {
                    return true;
                } else if (setWay(maze, i - 1, j)) {
                    return true;
                } else if (setWay(maze, i, j - 1)) {
                    return true;
                } else {
                    //此路走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                //可能走过2,可能是墙1,可能不通 3
                return false;
            }
        }
    }

    private boolean setWayExe(int[][] maze, int i, int j) {
        if (maze[5][6] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                if (setWayExe(maze, i + 1, j)) {
                    return true;
                } else if (setWayExe(maze, i, j + 1)) {
                    return true;
                } else if (setWayExe(maze, i - 1, j)) {
                    return true;
                } else if (setWayExe(maze, i, j - 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public int[][] createMaze() {
        int[][] maze = new int[7][8];
        for (int i = 0; i < 8; i++) {
            maze[0][i] = 1;
            maze[6][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            maze[i][0] = 1;
            maze[i][7] = 1;
        }
        return maze;
    }

    private void printMaze(int[][] maze) {

        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.printf("" + anInt);
            }
            System.out.println();
        }
    }

}
