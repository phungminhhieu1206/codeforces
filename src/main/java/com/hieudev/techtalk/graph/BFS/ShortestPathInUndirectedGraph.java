package com.hieudev.techtalk.graph.BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * You are given an Undirected Graph having unit weight of the edges,
 * find the shortest path from src to all the vertex and
 * if it is unreachable to reach any vertex, then return -1 for that vertex.
 * Input:
 * n = 9, m = 10
 * edges=[[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]]
 * src=0
 * Output:
 * 0 1 2 1 2 3 3 4 4
 */
public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // số lượng case test
        while (T-- > 0) {
            int n = sc.nextInt(); // nhập số đỉnh
            int m = sc.nextInt(); // nhập số cạnh
            int[][] edge = new int[m][2]; // mảng cạnh mỗi case test: [[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]]
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            ShortestPathInUndirectedGraph obj = new ShortestPathInUndirectedGraph();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Giải pháp:
     * - mảng d[n]: với d[i] là độ dài ngắn nhất từ đỉnh src đến i
     * (Khởi tạo giá trị ban đầu là -1 cho tất cả các đỉnh)
     * - duyệt bfs, mỗi khi đến đỉnh v thì tính d[v] =  d[u] + 1
     * (với u là đỉnh được duyệt ngay trước v và có cạnh (u, v))
     */
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Đọc tập cạnh
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // init distance d
        int d[] = new int[n];
        Arrays.fill(d, -1);

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();

        d[src] = 0;
        visited[src] = true;
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    d[v] = d[u] + 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        return d;
    }
}
