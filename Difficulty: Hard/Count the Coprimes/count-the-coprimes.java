class Solution {
    int cntCoprime(int[] arr) {
        int MAX = 10001;
        int[] freq = new int[MAX];

        
        for (int val : arr) {
            freq[val]++;
        }

        
        int[] countMultiples = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                countMultiples[i] += freq[j];
            }
        }

        
        long[] cntGCD = new long[MAX];
        for (int i = MAX - 1; i >= 1; i--) {
            long totalPairs = (long) countMultiples[i] * (countMultiples[i] - 1) / 2;
            for (int j = 2 * i; j < MAX; j += i) {
                totalPairs -= cntGCD[j];
            }
            cntGCD[i] = totalPairs;
        }

        long totalPairs = (long) arr.length * (arr.length - 1) / 2;
        return (int) cntGCD[1]; 
    }
}
