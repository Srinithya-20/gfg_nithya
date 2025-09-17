class Solution {
    static String decodeString(String s) {
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}
