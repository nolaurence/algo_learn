package cn.nolaurence.labuladong.binary_search;

public class LeetCode704 {

    /**
     * 给定有n个元素的升序整形数组nums和一个目标值target, 写一个函数搜索nums中的
     * target，如果目标存在返回下标，否则返回-1
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
