package cn.nolaurence.labuladong.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class Leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            // 判断是否有交集
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.max(a2, b2)});
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
