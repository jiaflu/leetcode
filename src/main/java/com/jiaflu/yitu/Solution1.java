package com.jiaflu.yitu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int b = in.nextInt();
        List<List<Integer>> hourses = new ArrayList<>();
        List<List<Integer>> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(in.nextInt());
            }
            hourses.add(temp);
        }

        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                temp.add(in.nextInt());
            }
            cars.add(temp);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < hourses.size(); i++) {
            List<Integer> tempHourse = hourses.get(i);
            if (tempHourse.get(2) > b) {
                continue;
            } else {
                int money = b - tempHourse.get(2);
                for (int j = 0; j < cars.size(); j++) {
                    List<Integer> tempCar = cars.get(j);
                    if (tempCar.get(1) > money) {
                        continue;
                    } else {
                        int tempMax = 10 * tempHourse.get(0) - (tempHourse.get(1) / tempCar.get(0));
                        if (tempMax > max) {
                            max = tempMax;
                        }
                    }
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }
}
