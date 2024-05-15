package com.kafka.kafkaDemoProj.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maze {

    maze() {

    }

    public static void main(String[] args) {
        //System.out.println(count(3, 3));
        //path("", 3, 3);
        //List<String> list = pathRet("", 3, 3);
        //List<String> list = pathReturnDiagonal("", 3, 3);
        //System.out.println(list);

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        //pathRestriction(board, "", 0, 0);
        //allPaths(board, "", 0, 0);
        int[][] path = new int[board.length][board[0].length];
        allPathsPrint(board, "", path, 0, 0, 1);
    }


    public static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    public static void path(String path, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.print(path + " ");
        }
        if (r > 1) {
            path(path + "D", r - 1, c);
        }
        if (c > 1) {
            path(path + "R", r, c - 1);
        }
    }

    public static List<String> pathRet(String s, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        List<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(pathRet(s + "D", r - 1, c));
        }
        if (c > 1) {
            list.addAll(pathRet(s + "R", r, c - 1));
        }
        return list;
    }

    public static List<String> pathReturnDiagonal(String path, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(pathReturnDiagonal(path + "V", r - 1, c));
        }

        if (r > 1 && c > 1) {
            list.addAll(pathReturnDiagonal(path + "D", r - 1, c - 1));
        }

        if (c > 1) {
            list.addAll(pathReturnDiagonal(path + "H", r, c - 1));
        }
        return list;
    }

    public static void pathRestriction(boolean[][] maze, String p, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestriction(maze, p + "D", r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestriction(maze, p + "R", r, c + 1);
        }
    }

    //  BACKTRACKING (BELOW TWO allPaths and allPathsPrint)

    public static void allPaths(boolean[][] maze, String path, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPaths(maze, path + "D", r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPaths(maze, path + "R", r, c + 1);
        }
        if (r > 0) {
            allPaths(maze, path + "U", r - 1, c);
        }

        if (c > 0) {
            allPaths(maze, path + "L", r, c - 1);
        }

        maze[r][c] = true;
    }

    public static void allPathsPrint(boolean[][] maze, String s, int[][] path, int row, int col, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] each : path) {
                System.out.println(Arrays.toString(each));
            }
            System.out.println(s);
            System.out.println();
            return;
        }

        if (!maze[row][col]) {
            return;
        }
        maze[row][col] = false;
        path[row][col] = step;

        if (row < maze.length - 1) {
            allPathsPrint(maze, s + "D", path, row + 1, col, step + 1);
        }

        if (col < maze[0].length - 1) {
            allPathsPrint(maze, s + "R", path, row, col + 1, step + 1);
        }

        if (row > 0) {
            allPathsPrint(maze, s + "U", path, row - 1, col, step + 1);
        }

        if (col > 0) {
            allPathsPrint(maze, s + "L", path, row, col - 1, step + 1);
        }

        maze[row][col] = true;
        path[row][col] = 0;

    }
}
