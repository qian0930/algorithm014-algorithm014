package com.hbq.aop.algorithm.week04;

public class BestTimeToBuyAndSellStock2  {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int p = 0;
        int q = 1;

        int res = 0;
        while (q < len) {
            //先移动p，直到prices[q]比prices[p]大
            while (q < len && prices[p] > prices[q]) {
                p++;
                q++;
            }
            //移动q，直到prices[q + 1]比prices[q]小
            while (q < len - 1 && prices[q + 1] > prices[q]) {
                q++;
            }
            if (q >= len) {
                return res;
            }
            res += prices[q] - prices[p];
            p = q + 1;
            q = p + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 7,6,4,3,1 };
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(arr));
    }
}
