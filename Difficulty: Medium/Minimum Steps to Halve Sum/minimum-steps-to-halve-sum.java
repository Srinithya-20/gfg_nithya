import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        double totalSum = 0;
        for (int num : arr) totalSum += num;
        double halfSum = totalSum / 2.0;
        double currSum = totalSum;
        int operations = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.add((double) num);
        }
        while (currSum > halfSum) {
            double largest = maxHeap.poll();
            double halved = largest / 2.0;
            currSum -= (largest - halved);
            maxHeap.add(halved);
            operations++;
        }
        return operations;
    }
}
