class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1; // no proper non-empty prefix possible
        
        int[] lps = new int[n];
        // Build LPS (KMP prefix table)
        for (int i = 1, len = 0; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        
        // Walk down the LPS chain to find the smallest positive border
        int candidate = lps[n - 1];
        int smallestPositiveBorder = 0;
        while (candidate > 0) {
            smallestPositiveBorder = candidate; // will end up as smallest positive
            candidate = lps[candidate - 1];
        }
        
        if (smallestPositiveBorder == 0) return -1;
        return n - smallestPositiveBorder; // largest periodic proper prefix
    }
}
