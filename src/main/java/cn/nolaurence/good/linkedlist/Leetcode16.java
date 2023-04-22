package cn.nolaurence.good.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Leetcode16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        // 记录三个数之和与目标值的偏差
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 固定nums[i] 为三个数之和中的第一个数
            // 然后对 nums[i+1..] 搜索接近target - nums[i] 的两个数之和
            int sum = nums[i] + twoSumClosest(nums, i + 1, target - nums[i]);
            if (Math.abs(delta) > Math.abs(target - sum)) {
                delta = target - sum;
            }
        }
        return target - delta;
    }

    // 在nums[start..] 中搜索接近target的两个数之和
    int twoSumClosest(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        // 记录两数之和与目标值的偏差
        int delta = Integer.MAX_VALUE;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (Math.abs(delta) > Math.abs(target - sum)) {
                delta = target - sum;
            }
            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return target - delta;
    }

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
