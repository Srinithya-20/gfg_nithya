class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxTime = 0;

        for (int pos : left) {
            // Time = distance to fall off (0)
            maxTime = Math.max(maxTime, pos);
        }

        for (int pos : right) {
            // Time = distance to fall off (n)
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}