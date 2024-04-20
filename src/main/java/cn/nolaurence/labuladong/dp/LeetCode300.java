package cn.nolaurence.labuladong.dp;

import java.util.Arrays;

public class LeetCode300 {
    /**
     * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度
     * 子序列是由数组派生而来的序列，例如[3,6,2,7]是数组[0,3,1,6,2,2,7]的子序列
     */
    public static int lengthOfLIS(int[] nums) {

        // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int bstForLengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /** 搜索左侧边界的二分搜索**/
            int left = 0, right = piles;
            while(left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }
}
