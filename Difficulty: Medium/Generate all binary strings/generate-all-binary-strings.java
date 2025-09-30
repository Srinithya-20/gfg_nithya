import java.util.*;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateBinary(n, "", result);
        return result;
    }
    
    private void generateBinary(int n, String current, ArrayList<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        // First add '0', then '1' to ensure ascending order
        generateBinary(n, current + "0", result);
        generateBinary(n, current + "1", result);
    }
}
