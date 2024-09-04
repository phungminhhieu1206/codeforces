package com.hieudev.codeforces.vpc_2024_test;

import java.util.*;

public class _D_SafeNetwork {
    private int n, m;
    private List<Integer>[] adj;
    private boolean[] visited;
    private int[] tin, low, component;
    private int timer, componentCount;

    public _D_SafeNetwork(int n, int m) {
        this.n = n;
        this.m = m;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        tin = new int[n];
        low = new int[n];
        component = new int[n];
        timer = 0;
        componentCount = 0;
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
                    // Nếu to là cầu, đánh dấu đỉnh "to" như là một phần của thành phần mới.
                    componentCount++;
                    component[to] = componentCount;
                }
            }
        }
        if (component[v] == 0) {
            component[v] = componentCount;
        }
    }

    public void findComponents() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentCount++;
                dfs(i, -1);
            }
        }
    }

    public int countBridgesToAdd() {
        // Đếm số lượng thành phần liên thông và số lượng cầu cần thêm.
        findComponents();
        int[] degree = new int[componentCount + 1];
        for (int v = 0; v < n; v++) {
            for (int to : adj[v]) {
                if (component[v] != component[to]) {
                    degree[component[v]]++;
                }
            }
        }
        int leaves = 0;
        for (int i = 1; i <= componentCount; i++) {
            if (degree[i] == 1) {
                leaves++;
            }
        }
        return (leaves + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        _D_SafeNetwork network = new _D_SafeNetwork(n, m);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            network.addEdge(u, v);
        }

        int minAdditionalEdges = network.countBridgesToAdd();
        System.out.println(minAdditionalEdges);
    }
}
