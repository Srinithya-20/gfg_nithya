class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        int count = 0;
        int sum = 0;
        prefixCount.put(0, 1);
        for (int num : arr) {
            sum += num;
            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}