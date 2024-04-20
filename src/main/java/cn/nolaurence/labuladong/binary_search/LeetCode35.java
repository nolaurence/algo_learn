package cn.nolaurence.labuladong.binary_search;

public class LeetCode35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不
     * 存在于数组中，返回他将会被按顺序插入的位置
     *
     * point：必须使用时间复杂度为O(log n) 的算法
     */
    public static int searchInsert(int[] nums, int target) {
        return leftBound(nums, target);
    }

    public static int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        // 因为插入位置可以是最后一个元素的后面，所以
        // 不用减一
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;  // 同right赋值的原因
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(nums, target));
    }
}
