package com.hieudev.techtalk.graph.BFS._1091_ShortestPathInBinaryMatrix;

import java.util.*;
import java.lang.*;
import java.io.*;

public class _1091_ShortestPathInBinaryMatrix
{
 public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    // Đường đi duyệt theo BFS là đường đi ngắn nhất rồi!
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        // Các hướng đi
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();

        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1}); // row, column, distance

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) // reach dest
                return cur[2];

            for (int[] direction : directions) {
                int r = cur[0] + direction[0];
                int c = cur[1] + direction[1];

                if (Math.min(r, c) < 0 || Math.max(r, c) >= n
                        || grid[r][c] == 1 || visited[r][c])
                    continue;

                visited[r][c] = true;
                queue.add(new int[]{r, c, cur[2] + 1}); // r, c, new distance
            }
        }
        return -1;
    }
}