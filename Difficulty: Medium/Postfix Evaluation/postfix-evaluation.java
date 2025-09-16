class Solution {
    public int evaluatePostfix(String[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (String token : arr) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = Math.floorDiv(a, b);
                        break;
                    case "^":
                        result = (int)Math.pow(a, b);
                        break;
                }
                
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
}
