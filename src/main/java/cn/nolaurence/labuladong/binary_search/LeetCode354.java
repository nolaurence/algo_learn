package cn.nolaurence.labuladong.binary_search;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode354 {
    /**
     * 俄罗斯套娃信封问题
     * 给你一个二位整数数组envelopes，其中envelopes[i] = [wi, hi]，标识
     * 第i个信封的宽度和高度。
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封
     * 里，如同俄罗斯套娃一样。
     * 请计算 最多能有多少个信封能组成一组 俄罗斯套娃 信封（即可以把一个信封放到另一个
     * 信封里面）
     *
     * 注意：不允许旋转信封
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public static int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0, right = piles;

            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
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
        int[][] envelopes = new int[][]{
                new int[]{5, 4},
                new int[]{6, 4},
                new int[]{6, 7},
                new int[]{2, 3},
        };
        System.out.println(maxEnvelopes(envelopes));
    }

}
