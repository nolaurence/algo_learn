package cn.nolaurence.good.linkedlist;

import java.util.Arrays;

public class Leetcode259 {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    int twoSumSmaller(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        int count = 0;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                // lo 和 lo + 1 到hi的任意个数相加都小于target
                count += hi - lo;
                lo++;
            } else {
                hi--;
            }
        }
        return count;
    }
}
