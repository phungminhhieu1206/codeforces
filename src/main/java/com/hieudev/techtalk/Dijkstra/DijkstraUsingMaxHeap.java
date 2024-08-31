package com.hieudev.techtalk.Dijkstra;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class DijkstraUsingMaxHeap {
    static class Edge {
        int v;
        double w;

        public Edge(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; ++i) {
            int[] e = edges[i];
            int u = e[0];
            int v = e[1];
            double w = succProb[i];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        return dijkstra(graph, start_node, end_node);
    }

    public static double dijkstra(List<Edge>[] graph, int src, int dst) {
        int n = graph.length;
        double[] dist = new double[n];

        dist[src] = 1.0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.w, o1.w));
        pq.offer(new Edge(src, 1.0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.v;

            for (Edge edge : graph[u]) {
                int v = edge.v;
                double vW = edge.w;
                double tempDist = dist[u] * vW;
                if (tempDist > dist[v]) {
                    dist[v] = tempDist;
                    pq.offer(new Edge(v, tempDist));
                }
            }
        }
        return dist[dst] != 0 ? dist[dst] : 0;
    }
}