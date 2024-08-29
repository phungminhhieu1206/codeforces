/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
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

        // BFS all paths from source s to reachable vertices
        public void bfs(int s) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                int u = queue.remove();
                // process u
                System.out.print(u + " ");

                for (int v : adj[u]) {
                    if (!visited[v]) {
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