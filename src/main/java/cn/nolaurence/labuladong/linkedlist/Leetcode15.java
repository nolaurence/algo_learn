package cn.nolaurence.labuladong.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {

    // try to solve 2sum
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据sum和target的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else { // sum == tagret
                return new int[]{nums[lo], nums[hi]};
            }
        }
        return null;
    }

    public int[][] twoSumTarget(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
//        while (lo < hi) {
//            int sum = nums[lo] + nums[hi];
//            // 根据 sum 和 target 的比较，移动左右指针
//            if (sum < target) {
//                lo++;
//            } else if (sum > target) {
//                hi--;
//            } else {
//        此处会出现重复值（数组中元素并没有不能重复）
//                res.add(new int[]{nums[lo], nums[hi]});
//                lo++;
//                hi--;
//            }
//        }
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录值
            int left = nums[lo], right = nums[hi];
//            if (sum < target) {
//                lo++;
//            } else if (sum > target) {
//                hi--;
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                res.add(new int[]{left, right});
                // 跳过所有重复的元素
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] twoSumTarget(int[] nums, int start, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录值
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                res.add(new int[]{left, right});
                // 跳过所有重复的元素
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] threeSum(int[] nums) {
        // c求和为0的三元组
        return threeSumTarget(nums, 0);
    }

    private int[][] threeSumTarget(int[] nums, int target) {
        // 数组需排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算twoSum
            int[][] tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (int[] tuple : tuples) {
                tuple = new int[]{tuple[0], tuple[1], nums[i]};
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复的结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        if (n < 2 || sz < n) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
         // twoSum是基本情况
        if (n == 2) {
            // 双指针
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    res.add(new int[]{left, right});
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            // n > 2时，递归计算(n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                int[][] sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (int[] arr : sub) {
                    int[] tmp = new int[arr.length + 1];
                    for (int j = 0; j < tmp.length; j++) {
                        tmp[j] = arr[j];
                    }
                    tmp[arr.length] = nums[i];
                    res.add(tmp);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[][] res = threeSumTarget(nums, 0);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
