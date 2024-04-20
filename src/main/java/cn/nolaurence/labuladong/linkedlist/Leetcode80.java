package cn.nolaurence.labuladong.linkedlist;

public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        int count = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 当一个重复元素不超过2时也往后移slow
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                // 遇到不同的元素
                count = 0;
            }
        }
        return slow + 1;
    }
}
