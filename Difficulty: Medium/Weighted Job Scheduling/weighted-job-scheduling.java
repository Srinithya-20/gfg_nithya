import java.util.*;

class Solution {
    public int maxProfit(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i][2];
            int l = binarySearch(jobs, i);
            if (l != -1) includeProfit += dp[l];
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }
        return dp[n - 1];
    }

    private int binarySearch(int[][] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[index][0]) {
                if (mid + 1 < jobs.length && jobs[mid + 1][1] <= jobs[index][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
