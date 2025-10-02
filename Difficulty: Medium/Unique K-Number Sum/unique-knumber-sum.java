class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int start, int target, int k, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0 || current.size() > k) return;
        
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, target - i, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}
