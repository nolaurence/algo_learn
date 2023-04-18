package cn.nolaurence.good.linkedlist;

import org.junit.jupiter.api.Test;

public class Leetcode283 {
    public void moveZeros(int[] nums) {
        // 返回去除0之后的数组的长度
        int p = removeElement(nums, 0);
        // 将p字后的所有元素赋值为0
        for (; p < nums.length ; p++) {
            nums[p] = 0;
        }
    }

    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test() {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        System.out.print("{");
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println("}");
    }
}
