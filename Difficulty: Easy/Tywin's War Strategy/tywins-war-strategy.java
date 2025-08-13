class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int requiredLucky = (n + 1) / 2;
        int currentLucky = 0;
        List<Integer> costs = new ArrayList<>();
        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                currentLucky++;
            } else {
                costs.add(k - (soldiers % k));
            }
        }
        if (currentLucky >= requiredLucky) return 0;
        Collections.sort(costs);
        int need = requiredLucky - currentLucky;
        int totalAdd = 0;
        
        for (int i = 0; i < need; i++) {
            totalAdd += costs.get(i);
        }
        return totalAdd;
    }
}