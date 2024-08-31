package com.hieudev.techtalk.graph._207_CourseSchedule;

import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
public class _207_CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 1}, {0, 2}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // init in-degree arr
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adj[prerequisite[1]].add(prerequisite[0]);
        }

        // init queue with all vertices with in-degree = 0
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order.size() == numCourses;

    }
}