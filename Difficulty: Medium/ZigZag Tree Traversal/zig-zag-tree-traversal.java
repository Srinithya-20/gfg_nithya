/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                int index = leftToRight ? i : (size - 1 - i);
                level[index] = current.data;
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            for (int val : level) result.add(val);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}
