package com.hieudev.techtalk.graph._NumberOfProvinces;/* package whatever; // don't place package name! */

import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
public class _NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, int u, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < isConnected.length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                dfs(isConnected, v, visited);
            }
        }
    }
}