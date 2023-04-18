package cn.nolaurence.good.linkedlist;

import org.junit.jupiter.api.Test;

public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;  // 需要小一点，往左移动
            } else {  // 需要大一点，往下移动
                i++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
    }
}
