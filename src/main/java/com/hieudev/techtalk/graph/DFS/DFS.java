package com.hieudev.techtalk.graph.DFS;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Quan tâm đến:
 * + đỉnh nguồn: s,
 * + tập cạnh: adj[]
 * ---------------------------
 * Bắt đầu từ u -> Thêm u vào stack
 * stack.pop() thăm u. và thêm các đỉnh có cạnh với u vào stack
 * stack.pop dần và lặp lại cho đến khi stack rỗng
 */
public class DFS {
    static class Graph {
        private final int V; // number of vertices
        private final ArrayList<Integer>[] adj; // adjacency list

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        // -----------------------------------------------------------------

        public void dfsRecursive(int s) {
            boolean[] visited = new boolean[V];
            dfs(s, visited);
        }

        // recursive DFS
        private void dfs(int s, boolean[] visited) {
            visited[s] = true;
            System.out.print(s + ", ");
            for (int v : adj[s]) {
                if (!visited[v]) {
                    dfs(v, visited);
                }
            }
        }

        // stack DFS
        public void dfsStack(int s) {
            Deque<Integer> stack = new ArrayDeque<>();
            boolean[] visited = new boolean[V];
            stack.push(s);
            while (!stack.isEmpty()) {
                int u = stack.pop();
                if (!visited[u]) {
                    visited[u] = true; // only mark visited when pop from stack
                    // process u
                    System.out.print(u + ", ");

                    for (int v : adj[u]) {
                        if (!visited[v]) {
                            stack.push(v);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        Graph g = new Graph(V);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(3,1);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(5,4);
        g.addEdge(6,3);

        System.out.print("Start recursive DFS from 1: ");
        g.dfsRecursive(0);
        System.out.print("\nStart stack DFS from 1: ");
        g.dfsStack(0);
        System.out.println();
    }
}