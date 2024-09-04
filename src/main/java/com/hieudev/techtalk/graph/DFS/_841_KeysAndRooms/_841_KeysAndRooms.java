package com.hieudev.techtalk.graph.DFS._841_KeysAndRooms;

import java.util.*;
import java.lang.*;

/**
 * Cho n phòng đánh số từ: 0 -> n-1, ngoài phòng 0 đầu tiên thì các phòng khác đều có khóa,
 * Khi vào 1 phoòng có thể tìm được 1 bộ khóa có đánh số để mở khóa các phòng khác.
 * Return true (nêu thăm được hết các phòng).
 * Vd1: rooms = [[1],[2],[3],[]] -> true
 * Vd2: rooms = [[1,3],[3,0,1],[2],[0]] -> false
 */
public class _841_KeysAndRooms {
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