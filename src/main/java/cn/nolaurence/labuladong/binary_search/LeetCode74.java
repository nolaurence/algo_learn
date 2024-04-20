package cn.nolaurence.labuladong.binary_search;

public class LeetCode74 {
    /**
     * 编写一个高效的算法来判断 m x n矩阵中，是否存在一个目标值。该矩阵
     * 具有如下特性：每行中的证书从左到右按升序排列；每行的第一个整数大于
     * 前一行的最后一个整数
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (get(matrix, mid) == target) {
                return true;
            } else if (get(matrix, mid) < target) {
                left = mid + 1;
            } else if (get(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维矩阵中的横坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        };
        int target = 3;


    }
}
