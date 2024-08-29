/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
         // construct adj list from edges
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        // init distance arr
        int[] d = new int[n];
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