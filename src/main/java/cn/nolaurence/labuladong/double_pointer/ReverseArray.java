package cn.nolaurence.labuladong.double_pointer;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;

public class ReverseArray {

    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // exchange nums[left] and nums[right]
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        reverse(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
