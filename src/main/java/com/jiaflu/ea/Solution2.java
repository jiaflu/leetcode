//package com.jiaflu.ea;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//
//import java.util.*;
//
//public class Solution2 {
////    static TreeMap<Integer, Boolean> res = new TreeMap<>();
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        int n = in.nextInt();
////        int m = in.nextInt();
////        int money = in.nextInt();
////        int[][] dis = new int[n][n];
////        int[][] cost = new int[n][n];
////        HashMap<Integer, List<Integer>> map = new HashMap<>();
////        for (int i = 0; i < m; i++) {
////            int start = in.nextInt();
////            int end = in.nextInt();
////            int distance = in.nextInt();
////            int c = in.nextInt();
////            dis[start][end] = distance;
////            cost[start][end] = c;
////            if (map.containsKey(start)) {
////                map.get(start).add(end);
////            }else {
////                List<Integer> list = new ArrayList<>();
////                list.add(end);
////                map.put(start, list);
////            }
////        }
////        dfs(0, C, dia   );
////
////
////    }
//
//    public static void dfs(int start, int C, int[][] cost, int[][] distance, int N, int p, HashMap<Integer, List<Integer>> map) {
//        if (start == N-1) {
//            if (C >= 0) {
//                res.put(p, true);
//            } else {
//                res.put(p, false);
//            }
//            return;
//        }
//        if (C < 0) {
//            return;
//        }
//        if (!map.containsKey(start)) {
//            return;
//        }
//        List<Integer> list = map.get(start);
//        for (int i = 0; i < list.size(); i++) {
//            int end = list.get(i);
//            dfs(end, C - cost[start][end], cost, distance, N, p+distance[start][end], map);
//        }
//
//    }
//}
