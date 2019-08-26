package com.jiaflu.yuanfudao;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution3 {
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
            while (priorityQueue.size() > 2) {
                int[] arr = new int[priorityQueue.size()];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = priorityQueue.poll() -1;
                }
                cnt++;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > 0) {
                        priorityQueue.add(arr[j] - 1);
                    }
                }
            }
            list.add(cnt);

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
