package com.hieudev.techtalk.graph.BFS;

import java.util.*;
import java.lang.*;

public class BFS {
    static class Graph {
        private final int V; // number of vertices: tập đỉnh
        private final ArrayList<Integer>[] adj; // adjacency list: lưu cạnh

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V]; // Danh sách kề để biểu diễn cạnh
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        // cạnh (u, v)
        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        // -----------------------------------------------------------------

        // BFS all paths from source s to reachable vertices
        public void bfs(int s) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                int u = queue.remove(); // 1. thăm đỉnh u
                // process u
                System.out.print(u + " ");

                for (int v : adj[u]) { // 2. duyệt tất cả đỉnh có cạnh với u
                    if (!visited[v]) { // 2.1 nếu chưa thăm thì tiến thành thăm, ngược lại thì pass qua
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(11);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 7);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 0);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
        g.addEdge(5, 8);
        g.addEdge(6, 3);
        g.addEdge(6, 7);
        g.addEdge(7, 2);
        g.addEdge(7, 6);
        g.addEdge(7, 8);
        g.addEdge(7, 9);
        g.addEdge(8, 5);
        g.addEdge(8, 7);
        g.addEdge(8, 10);
        g.addEdge(9, 7);
        g.addEdge(10, 8);

        System.out.print("Start BFS from 0: ");
        g.bfs(0);
    }
}