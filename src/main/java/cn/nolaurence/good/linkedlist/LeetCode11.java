package cn.nolaurence.good.linkedlist;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 计算面积
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
