package com.hieudev.techtalk.graph.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * + Tìm tất cả các thành phần liên thông: Xác định các thành phần liên thông của đồ thị.
 * + Xây dựng một đồ thị mới (đồ thị thành phần): Mỗi thành phần liên thông của đồ thị ban đầu sẽ trở thành một đỉnh
 * trong đồ thị mới. Các cầu giữa các thành phần liên thông trong đồ thị ban đầu sẽ trở thành các cạnh trong đồ thị mới này.
 * + Xác định số lượng cạnh tối thiểu cần thêm: Để đồ thị mới (đồ thị thành phần) là một đồ thị liên thông,
 * cần ít nhất số cạnh bằng với (số thành phần - 1). Điều này là bởi vì một đồ thị liên thông đơn giản với k đỉnh cần ít nhất k-1 cạnh.
 * --------------------------------------------------------------------------------------------------------------------
 * + Xây dựng đồ thị thành phần: Tạo ra một đồ thị mới, trong đó mỗi thành phần liên thông của đồ thị
 * ban đầu là một đỉnh. Sau đó, xác định số lượng lá trong đồ thị mới.
 * + Tính số cạnh cần thêm: Để liên thông các thành phần, ta cần ít nhất (leaves + 1) / 2 cạnh mới
 */
public class BridgeToGraph {
    private int n, m;
    private List<Integer>[] adj;
    private boolean[] visited;
    private int[] tin, low, component;
    private int timer, componentCount;

    public BridgeToGraph(int n, int m) {
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
        BridgeToGraph network = new BridgeToGraph(n, m);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            network.addEdge(u, v);
        }

        int minAdditionalEdges = network.countBridgesToAdd();
        System.out.println(minAdditionalEdges);
    }
}
