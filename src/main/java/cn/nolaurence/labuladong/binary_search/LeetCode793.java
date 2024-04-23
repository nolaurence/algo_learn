package cn.nolaurence.labuladong.binary_search;

import org.junit.jupiter.api.Test;

public class LeetCode793 {

    /**
     * f(x)是x！末尾是0的数量（阶乘）
     * 例如 f(3) = 0,因为 3！=6的末尾没有0；而f(11) = 2,因为11！=39916800末尾
     * 有两个0。给定K，找出多少个非负整数x，能满足f(x) = K
     */
    public int preimageSizeFZF(int K) {
        return (int) (rightBound(K) - leftBound(K) + 1);
    }

    long trailingZeros(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += 5;
        }
        return res;
    }

    long leftBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeros(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeros(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    long rightBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeros(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeros(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    @Test
    public void test() {
        int k = 0;
        System.out.println(preimageSizeFZF(k));
    }
}
