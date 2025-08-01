class Solution {
    public int countBalanced(String[] arr) {
        int totalVowel = 0;
        int totalConsonant = 0;
        Map<Integer, Integer> diffMap = new HashMap<>();
        diffMap.put(0, 1); 
        
        int count = 0;
        
        for (String s : arr) {
            for (char ch : s.toCharArray()) {
                if (isVowel(ch)) totalVowel++;
                else totalConsonant++;
            }
            
            int diff = totalVowel - totalConsonant;
            count += diffMap.getOrDefault(diff, 0);
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
        }
        
        return count;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
