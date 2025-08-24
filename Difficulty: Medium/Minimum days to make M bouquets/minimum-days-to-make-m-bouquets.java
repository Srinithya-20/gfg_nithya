class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        if ((long) m * k > arr.length) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int x : arr) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, k, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int k, int m, int day) {
        int count = 0;
        int bouquets = 0;

        for (int x : arr) {
            if (x <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }
}
