import java.util.*;

class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        
        q.add("1"); 
        
        for (int i = 0; i < n; i++) {
            String s = q.poll();
            result.add(s);
            
            
            q.add(s + "0");
            q.add(s + "1");
        }
        
        return result;
    }
}