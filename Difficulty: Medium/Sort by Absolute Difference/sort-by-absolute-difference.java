import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], Math.abs(arr[i] - x), i);
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a.diff != b.diff) return a.diff - b.diff;
            return a.index - b.index;
        });

        for (int i = 0; i < n; i++) {
            arr[i] = pairs[i].val;
        }
    }

    static class Pair {
        int val, diff, index;
        Pair(int v, int d, int i) {
            val = v;
            diff = d;
            index = i;
        }
    }
}
