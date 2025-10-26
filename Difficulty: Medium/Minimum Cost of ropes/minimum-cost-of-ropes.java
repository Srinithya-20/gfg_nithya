import java.util.*;

class Solution {
    public static int minCost(int[] arr) {
        if (arr.length <= 1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) pq.add(a);

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);
        }

        return totalCost;
    }
}
