package com.jiaflu.xiaomi;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    static int min;
    static int solution(int[] prices, int budget) {
        Arrays.sort(prices);
        min = Integer.MAX_VALUE;
        search(prices, budget, prices.length-1, 0, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    static void search(int[] prices, int budget, int index, int cnt, int sum) {
        if (sum == budget) {
            if (cnt < min) {
                min = cnt;
            }
            return;
        }
        if (index < 0 || cnt >= min || sum > budget) {
            return;
        }

        // 继续去当前
        search(prices, budget, index, cnt+1, sum + prices[index]);
        //
        search(prices, budget, index-1, cnt, sum);

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
