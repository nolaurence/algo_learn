package cn.nolaurence.labuladong.dp;

import org.junit.jupiter.api.Test;

public class FibArray {

    int fib(int N) {
        int[] memo = new int[N+1];
        return helper(memo, N);
    }

    int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    int newFib(int N) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    int ultraFib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        return 0;
    }
}
