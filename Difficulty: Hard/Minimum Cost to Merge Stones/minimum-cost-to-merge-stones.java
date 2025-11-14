class Solution {
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        
        if ((n - 1) % (k - 1) != 0) return -1;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        int[][][] dp = new int[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 1; t <= k; t++) {
                    dp[i][j][t] = Integer.MAX_VALUE / 3;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                for (int t = 2; t <= k; t++) {
                    for (int mid = i; mid < j; mid += (k - 1)) {
                        if (dp[i][mid][1] == Integer.MAX_VALUE / 3 ||
                            dp[mid + 1][j][t - 1] == Integer.MAX_VALUE / 3) 
                            continue;

                        dp[i][j][t] = Math.min(dp[i][j][t],
                                dp[i][mid][1] + dp[mid + 1][j][t - 1]);
                    }
                }

                if (dp[i][j][k] < Integer.MAX_VALUE / 3) {
                    dp[i][j][1] = dp[i][j][k] + (prefix[j + 1] - prefix[i]);
                }
            }
        }

        return dp[0][n - 1][1];
    }
}
