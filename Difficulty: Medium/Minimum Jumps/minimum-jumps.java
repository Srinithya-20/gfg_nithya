class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;
        
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            if (farthest <= i) return -1;
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
                if (currEnd >= n - 1) return jumps;
            }
        }
        return -1;
    }
}
