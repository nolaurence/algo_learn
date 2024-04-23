package cn.nolaurence.labuladong.double_pointer;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > right) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        System.out.println(JSON.toJSONString(twoSum(nums, target)));
    }
}
