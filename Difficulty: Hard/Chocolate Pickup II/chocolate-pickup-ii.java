class Solution {
    private int[][][] dp;
    private int n;

    public int chocolatePickup(int[][] mat) {
        n = mat.length;
        dp = new int[n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;
        int result = helper(mat, 0, 0, 0);
        return Math.max(0, result);
    }

    private int helper(int[][] mat, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || mat[r1][c1] == -1 || mat[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (r1 == n - 1 && c1 == n - 1)
            return mat[r1][c1];
        if (dp[r1][c1][r2] != Integer.MIN_VALUE)
            return dp[r1][c1][r2];
        int chocolates = mat[r1][c1];
        if (r1 != r2 || c1 != c2)
            chocolates += mat[r2][c2];
        int temp = Math.max(
            Math.max(helper(mat, r1 + 1, c1, r2 + 1), helper(mat, r1, c1 + 1, r2)),
            Math.max(helper(mat, r1 + 1, c1, r2), helper(mat, r1, c1 + 1, r2 + 1))
        );
        chocolates += temp;
        dp[r1][c1][r2] = chocolates;
        return chocolates;
    }
}
