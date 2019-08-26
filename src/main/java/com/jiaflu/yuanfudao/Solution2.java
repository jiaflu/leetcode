package com.jiaflu.yuanfudao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
                return y - x;
            });
            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                int temp = in.nextInt();
                if (temp != 0) {
                    priorityQueue.add(temp);
                }
            }
            int cnt = 0;
            int t1, t2, t3;
            while (priorityQueue.size() > 2) {

                t1 = priorityQueue.poll() -1;
                t2 = priorityQueue.poll() -1;
                t3 = priorityQueue.poll() -1;
                cnt++;
                if (t1 > 0) {
                    priorityQueue.add(t1 - 1);
                }
                if (t2 > 0) {
                    priorityQueue.add(t2 - 1);
                }
                if (t3 > 0) {
                    priorityQueue.add(t3 - 1);
                }
            }
            System.out.println(cnt);

        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
