package com.jiaflu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目：K 站中转内最便宜的航班
 *
 * 解答：
 *
 */

public class $787_Cheapest_Flights_Within_K_Stops {
    /**
     *  基于最短路径 Dijkstra 算法, 加上了 k 中转的约束, 利用一个优先队列按费用最低保存到达不同目标站
     *  所需的中间站数和费用, 每次从优先队列中 poll 出一个当前最小花费的站, 如果该站为 dst 则直接返回
     *  对应的费用(优先队列保证花费最低). 为了便于更新, 利用一个 map 保存不同的始发站可以到达的不同
     *  下一站的和费用
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights) {
            if(!map.containsKey(flight[0]))
                map.put(flight[0], new HashMap<>(0));
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        // 数组内元素依次为: 到达站的最低费用(fee)、到达站(tar)和经过中转的站数(k)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0]-b[0])
        );
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int fee = temp[0];
            int tar = temp[1];
            int k = temp[2];
            if(tar == dst) return fee;
            if(k <= K) {
                // 防止下一站城市不在map中
                Map<Integer, Integer> nextHops = map.getOrDefault(tar, new HashMap<>());
                for(Map.Entry<Integer, Integer> entry : nextHops.entrySet())
                pq.offer(new int[]{fee + entry.getValue(), entry.getKey(), k+1});
            }
        }

        return -1;
    }
}
