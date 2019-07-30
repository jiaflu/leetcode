package com.jiaflu.leetcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            int[] nArr = new int[n];
            int[][] mArr = new int[m][2];
            for (int i = 0; i < n; i++) {
                nArr[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                mArr[i][1] = in.nextInt()-1;
                mArr[i][0] = in.nextInt()-1;
            }
            int[] res = process(n, m , nArr, mArr);
            for(int i = 0; i < res.length; i++) {
                if (i < res.length -1) {
                    System.out.print((res[i]+1) + " ");
                } else {
                    System.out.print((res[i]+1));
                }
            }
            break;
        }
    }

    private static int[] process(int numCourses, int m, int[] nArr, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int min = findMin(q, nArr);
            int node = q.remove(min);
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each nei***or by 1
            if (adjList.containsKey(node)) {
                for (Integer neior : adjList.get(node)) {
                    indegree[neior]--;

                    // If in-degree of a nei***or becomes 0, add it to the Q
                    if (indegree[neior] == 0) {
                        q.add(neior);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    private static int findMin(List<Integer> q, int[] nArr) {
        int min = nArr[q.get(0)];
        int index = -1;
        for (int i = 0; i < q.size(); i ++) {
            if (min > nArr[q.get(i)]) {
                min = nArr[q.get(i)];
                index = i;
            }
        }
        return index == -1? 0 : index;
    }
}
