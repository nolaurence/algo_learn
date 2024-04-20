package cn.nolaurence.labuladong.binary_search;

import com.alibaba.fastjson2.JSON;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧比边界
                right = mid - 1;
            }
        }

        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩左侧边界
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        LeetCode34 instance = new LeetCode34();
        System.out.println(JSON.toJSONString(instance.searchRange(nums, target)));
    }
}
