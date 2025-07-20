class Solution {
    public int countValid(int n, int[] arr) {
        boolean[] forbidden = new boolean[10];
        for (int digit : arr) {
            forbidden[digit] = true;
        }

        List<Integer> allowedDigits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (!forbidden[i]) {
                allowedDigits.add(i);
            }
        }

        if (allowedDigits.size() == 0) return 0;

        int totalNDigitNumbers = 9 * (int)Math.pow(10, n - 1);
        int countInvalid = countNumbersWithOnlyAllowedDigits(n, allowedDigits);

        return totalNDigitNumbers - countInvalid;
    }

    private int countNumbersWithOnlyAllowedDigits(int n, List<Integer> allowed) {
        int count = 0;
        int len = allowed.size();

        for (int i = 0; i < allowed.size(); i++) {
            int first = allowed.get(i);
            if (first == 0) continue;
            count += countWithPrefix(n - 1, allowed);
        }

        return count;
    }

    private int countWithPrefix(int remainingDigits, List<Integer> allowed) {
        int ways = 1;
        int len = allowed.size();
        for (int i = 0; i < remainingDigits; i++) {
            ways *= len;
        }
        return ways;
    }
}
