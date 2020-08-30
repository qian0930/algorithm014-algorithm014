package com.hbq.aop.algorithm.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if (size < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int a = 0; a < size - 3; a++) {
            //确保nums[a]改变
            if (a > 0 && nums[a] == nums[a--]) {
                continue;
            }
            for (int b = a + 1; b < size - 2; b++) {
                //确保nums[b]改变
                if (b > 0 && nums[b] == nums[b--]) {
                    continue;
                }
                int c = b + 1;
                int d = size - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        res.add(Arrays.asList(a, b, c, d));
                        //确保num[c]改变
                        while (c < d && nums[c+ 1] == nums[c++]);
                        //确保num[d]改变
                        while (c < d && nums[d - 1] == nums[d--]);
                        c++;
                        d--;
                    }
                }
            }
        }

        return res;
    }
}
