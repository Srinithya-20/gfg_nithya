class Solution {
    public int maxProfit(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int hold = -arr[0];
        int sold = 0;
        int cool = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevCool = cool;

            hold = Math.max(prevHold, prevCool - arr[i]);
            sold = prevHold + arr[i];
            cool = Math.max(prevCool, prevSold);
        }

        return Math.max(sold, cool);
    }
}
