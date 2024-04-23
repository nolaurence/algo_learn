package cn.nolaurence.labuladong.binary_search;

public class LeetCode852 {

    // 寻找山脉数组，山顶两边的数字是单调增和单调减的
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果mid比mid+1小，说明mid在山脉左侧，山脉在右侧
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
