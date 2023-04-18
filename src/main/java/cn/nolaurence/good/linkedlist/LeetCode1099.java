package cn.nolaurence.good.linkedlist;

import java.util.Arrays;

public class LeetCode1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        // 数组双指针一般先排序
        Arrays.sort(nums);
        // 左右指针技巧
        int lo = 0, hi = nums.length - 1;
        int sum = -1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < k) {
                sum = Math.max(sum, nums[lo] + nums[hi]);
                lo++;
            } else {
                hi--;
            }
        }
        return sum;
    }
}
