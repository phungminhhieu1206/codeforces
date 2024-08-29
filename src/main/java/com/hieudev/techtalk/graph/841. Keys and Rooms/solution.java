/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int u, boolean[] visited) {
        visited[u] = true;
        for (int v : rooms.get(u)) {
            if (!visited[v]) {
                dfs(rooms, v, visited);
            }
        }
    }
}