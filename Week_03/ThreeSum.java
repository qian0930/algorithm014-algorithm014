package com.hbq.aop.algorithm.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if (size < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int a = 0; a < size - 2; a++) {
            //确保num[a]改变了
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = size - 1;
            int sum = nums[a] + nums[b] + nums[c];
            while (b < c) {
                if (sum < 0) {
                    b++;
                } else if (sum > 0) {
                    c--;
                } else {
                    res.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    //确保num[b]变化
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    //确保num[c]变化
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,0,1};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(arr));
    }
}
