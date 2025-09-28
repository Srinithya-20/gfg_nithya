import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        
        int left = 0, bestStart = 0, bestLen = 0;
        
        for (int right = 0; right < n; right++) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                left++;
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
            }
            
            int windowLen = right - left + 1;
            if (windowLen > bestLen) {
                bestLen = windowLen;
                bestStart = left;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
