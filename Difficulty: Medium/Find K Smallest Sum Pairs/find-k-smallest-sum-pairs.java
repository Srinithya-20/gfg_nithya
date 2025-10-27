import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n1 = arr1.length, n2 = arr2.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for (int i = 0; i < Math.min(n1, k); i++) {
            pq.offer(new int[]{arr1[i], arr2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int a = cur[0], b = cur[1], idx = cur[2];
            
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(a);
            pair.add(b);
            result.add(pair);
            
            if (idx + 1 < n2) {
                pq.offer(new int[]{a, arr2[idx + 1], idx + 1});
            }
        }

        return result;
    }
}
