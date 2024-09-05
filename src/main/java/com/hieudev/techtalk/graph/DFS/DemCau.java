package com.hieudev.techtalk.graph.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemCau {
    private int n, m;
    private List<Integer>[] adj;
    private boolean[] visited;
    private int[] tin, low;
    private int timer;
    private int bridges;

    public DemCau(int n, int m) {
        this.n = n;
        this.m = m;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        tin = new int[n];
        low = new int[n];
        timer = 0;
        bridges = 0;
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    private void dfs(int v, int p) {
        visited[v] = true;
        tin[v] = low[v] = timer++;
        for (int to : adj[v]) {
            if (to == p) continue;
            if (visited[to]) {
                low[v] = Math.min(low[v], tin[to]);
            } else {
                dfs(to, v);
                low[v] = Math.min(low[v], low[to]);
                if (low[to] > tin[v]) {
                    bridges++;
                }
            }
        }
    }

    public int findBridges() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
        return bridges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DemCau network = new DemCau(n, m);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            network.addEdge(u, v);
        }

        int minAdditionalEdges = network.findBridges();
        System.out.println(minAdditionalEdges);
    }
}
