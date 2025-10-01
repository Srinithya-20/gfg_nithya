import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrack(int[] arr, ArrayList<Integer> current, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            used[i] = true;
            current.add(arr[i]);
            backtrack(arr, current, used, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
